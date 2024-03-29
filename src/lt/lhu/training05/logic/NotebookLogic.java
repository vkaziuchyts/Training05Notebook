package lt.lhu.training05.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lt.lhu.training05.dao.NotebookDao;
import lt.lhu.training05.entity.Note;

public class NotebookLogic {
	private final NotebookDao dao = new NotebookDao();

	public void add(Note n) {
		// NoteBookDao dao = new NoteBookDao();

		dao.save(n);
	}

	public void add(String title, String content, Date date) {
		// NoteBookDao dao = new NoteBookDao();
		Note n = new Note(title, content, date);

		dao.save(n);
	}

	public List<Note> find(String text) {
		List<Note> result = new ArrayList<Note>();

		// NoteBookDao dao = new NoteBookDao();
		List<Note> myNotes = dao.allNotes();

		for (Note n : myNotes) {
			if (isTextInNote(n, text)) {
				result.add(n);
			}
		}

		/*
		 * for(int i=0; i<myNotes.size(); i++) { Note n = myNotes.get(i); }
		 */
		return result;

	}

	private boolean isTextInNote(Note n, String text) {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}

	public List<Note> find(Date date) {
		List<Note> result = new ArrayList<Note>();

		// NoteBookDao dao = new NoteBookDao();
		List<Note> myNotes = dao.allNotes();

		for (Note n : myNotes) {
			if (isDateInNote(n, date)) {
				result.add(n);
				// ...d1.equals(d2);
			}
		}
		return result;

	}

	private boolean isDateInNote(Note n, Date date) {
		return n.getD().equals(date);
	}

	public List<Note> allNotes() {
		return dao.allNotes();
	}

}
