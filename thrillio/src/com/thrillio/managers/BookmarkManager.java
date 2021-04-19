package com.thrillio.managers;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.Book;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.Movie;
import com.thrillio.entities.User;
import com.thrillio.entities.UserBookmark;
import com.thrillio.entities.WebLink;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {

		return instance;
	}

	public Book createBook(long id, String title, int publicationYear, String[] authors,
			String publisher, String genre, double amazonRating) {

		Book book = new Book();

		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setAuthors(authors);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double ImbdRating) {

		Movie movie = new Movie();

		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImbdRating(ImbdRating);
		
		return movie;
	}

	public WebLink createWebLinkManager(long id, String title, String url, String host) {

		WebLink webLink = new WebLink();
		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);

		return webLink;
	}
	
	public Bookmark[][] getBookmark() {
		return dao.getBookmark();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
		
	}

}
