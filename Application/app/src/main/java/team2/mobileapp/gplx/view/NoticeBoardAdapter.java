package team2.mobileapp.gplx.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;
import team2.mobileapp.gplx.Volley.model.NoticeBoard;

public class NoticeBoardAdapter extends ArrayAdapter<NoticeBoard> {

    Context context;
    ArrayList<NoticeBoard> arrayList;
    int layoutResource;


    public NoticeBoardAdapter(Context context, int resource, ArrayList<NoticeBoard>
            objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layoutResource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.listview_notice_board_item, null, false);

        TextView tvBoardCode = (TextView) convertView.findViewById(R.id.tv_board_code);
        tvBoardCode.setText(arrayList.get(position).getBoardCode());
        TextView tvBoardName = (TextView) convertView.findViewById(R.id.tv_board_name);
        ImageView ivBoardPhoto = (ImageView) convertView.findViewById(R.id.iv_board);
        tvBoardName.setText(arrayList.get(position).getBoardName());

        String uri = VariableGlobal.PHOTO1 + "BB" + VariableGlobal.PHOTO2 + arrayList.get(position).getPhoto() + VariableGlobal.PHOTO3+VariableGlobal.Token;
        Picasso.get()
                .load(uri)
                .placeholder(com.wooplr.spotlight.R.drawable.ic_spotlight_arc)
                .error(com.wooplr.spotlight.R.drawable.ic_spotlight_arc)
                .fit()
                .into(ivBoardPhoto);
        return convertView;
    }
}