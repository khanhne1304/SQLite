package Model;

public class NotesModel {
    private int idNote;
    private String nameNote;

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public NotesModel(int idNote, String nameNote) {
        this.idNote = idNote;
        this.nameNote = nameNote;
    }
}
