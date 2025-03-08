package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqllite.MainActivity;
import com.example.sqllite.R;

import java.util.List;

import Model.NotesModel;

public class NotesAdapter extends BaseAdapter {
    //Khai báo biến toàn cục
    private Context context;
    private int layout;
    private List<NotesModel> noteList;

    //tạo constructor
    public NotesAdapter(Context context, int layout, List<NotesModel> noteList) {
        this.context = context;
        this.layout = layout;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //tạo viewHolder
    private class ViewHolder {
        TextView textViewNote;
        ImageView imageViewEdit;
        ImageView imageViewDelete;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Use the ViewHolder pattern for performance
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, parent, false); // inflate with parent but don't attach
            viewHolder.textViewNote = convertView.findViewById(R.id.textViewNameNote);
            viewHolder.imageViewDelete = convertView.findViewById(R.id.imageViewDelete);
            viewHolder.imageViewEdit = convertView.findViewById(R.id.imageViewEdit);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Lấy giá trị của note theo vị trí
        final NotesModel notes = noteList.get(position);
        viewHolder.textViewNote.setText(notes.getNameNote());

        // Bắt sự kiện nút cập nhật
        viewHolder.imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Cập nhật " + notes.getNameNote(), Toast.LENGTH_SHORT).show();
                // Gọi Dialog cập nhật trong MainActivity
                ((MainActivity) context).DialogCapNhatNotes(notes.getNameNote(), notes.getIdNote());
            }
        });
        //bắt sự kiện xóa notes (Handle note deletion event)
        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).DialogDelete(notes.getNameNote(), notes.getIdNote());
            }
        });
        // (Nếu cần) Bắt sự kiện nút xóa ở đây, tương tự như nút chỉnh sửa

        return convertView;
    }





}
