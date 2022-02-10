package com.training.project.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.project.model.Book;
import com.training.project.model.Fine;

@Repository
@EnableTransactionManagement
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveOrUpdate(Book book) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);

	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("title"));
		List<Book> books = criteria.list();
		return books;

	}

	@Override
	@Transactional
	public void deleteBook(int id) {

		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		session.delete(book);

	}

	@Override
	@Transactional
	public Book getBookById(int id) {

		Session session = sessionFactory.openSession();
		Book book =session.get(Book.class, id);
		return book;

	}

	@Override
	@Transactional
	public Book getBookForIssueReturn(int id) {

		Session session = sessionFactory.openSession();
		Book book =session.get(Book.class, id);
		return book;

	}

	@Override
	@Transactional
	public void issueBook(Book book) {

		Session session = this.sessionFactory.getCurrentSession();
		if(book.getAvailableNo() > 0 ) {

			int n;
			n = book.getAvailableNo()-1;
			book.setAvailableNo(n);
			session.update(book);

		}else {

			JFrame f=new JFrame();
			f.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(f,"Book is not available");

		}

	}

	@Override
	@Transactional
	public void returnBook(Book book) {

		Session session = this.sessionFactory.getCurrentSession();
		Book book1 =session.get(Book.class,book.getId());
		String s1 =book.getUser().getDate();
		String s2 =book1.getUser().getDate();
		int n;
		if(book.getUser().getDate().compareTo(book1.getUser().getDate()) <= 0 ) {

			n = book.getAvailableNo()+1;
			book1.setId(book1.getId());
			book1.setAvailableNo(n);
			book1.setUser(null);
			System.out.println("biik od="+book.getId());
			session.save(book1);
			session.update(book1);

		}else {

			SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
			try {

				int id = book.getUser().getUserId();
				Date date1 = obj.parse(book.getUser().getDate());
				Date date2 = obj.parse(book1.getUser().getDate());
				long timeDifference = date1.getTime() - date2.getTime();
				long daysDifference = TimeUnit.MILLISECONDS.toDays(timeDifference) % 365;
				long fine = daysDifference*10;
				String date = book.getUser().getDate();
				Fine fineobj = new Fine(date,fine);
				book1.setFine( fineobj);
				n = book1.getAvailableNo()+1;
				book1.setId(book1.getId());
				book1.setAvailableNo(n);
				book1.setUser(null);
				session.save(fineobj);
				session.save(book1);
				session.update(book1);
				JFrame f=new JFrame();
				f.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(f,"Please pay the fine Rs."+fine);

			} catch (ParseException e) {

				e.printStackTrace();

			}

		}

	}

	@Override
	@Transactional
	public Book getBookForIssue(int id) {

		Session session = sessionFactory.openSession();
		Book book =session.get(Book.class, id);
		return book;

	}

}
