package team2.mobileapp.gplx.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.dto.QuestionDetails;

class QuestionListViewAdapter extends ArrayAdapter<QuestionDetails> {
    private Context context;
    private ArrayList<QuestionDetails> arrayList;
    int layoutResource;

    public QuestionListViewAdapter(Context context, int resource, ArrayList<QuestionDetails>
            objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layoutResource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView =
                LayoutInflater.from(context).inflate(R.layout.question_view_list_item, null,
                        false);
        TextView tvQuestion = (TextView) convertView.findViewById(R.id.tv_question_item_listview);
        TextView tvResult = (TextView) convertView.findViewById(R.id.tv_result_item_listview);
        TextView tvListAnswer = (TextView) convertView.findViewById(R.id.tv_list_answer);
        String listAnswer="";
        int index=arrayList.indexOf(arrayList.get(position));
        int lenList=arrayList.get(position).getAnswer().getAnswerName().length;
        for (int i = 0; i < lenList; i++) {
           String item=arrayList.get(position).getAnswer().getAnswerByIndex(i);
            listAnswer+=(i+1)+" - "+item+"\n\n";
        }


        int positionResult = arrayList.get(position).getAnswer().getResult();
        tvListAnswer.setText(listAnswer);
        tvQuestion.setText("Câu "+(index+1)+". "+arrayList.get(position).getQuestion().getQuery());
        tvResult.setText(arrayList.get(position).getAnswer().getResult()+1+" - "+arrayList.get(position).getAnswer().getAnswerByIndex(positionResult));
        if (!arrayList.get(position).getQuestion().getPhoto().isEmpty()) {
            try {
                String uri = arrayList.get(position).getQuestion().getPhoto().substring(0, arrayList.get(position).getQuestion().getPhoto().length() - 4);
                int imageResource = context.getResources().getIdentifier(uri, "drawable", context.getPackageName());
                Drawable res = context.getResources().getDrawable(imageResource);
                ImageView ivBoardPhoto = (ImageView) convertView.findViewById(R.id.iv_board);
                ivBoardPhoto.getLayoutParams().height = 600;
                ivBoardPhoto.getLayoutParams().width = 600;
                ivBoardPhoto.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_radius_10));
                ivBoardPhoto.requestLayout();
                ivBoardPhoto.setImageDrawable(res);
            } catch (Exception ex) {
                Log.i("Error", "Image not exits ");
            }
        }

// Get item
        return convertView;
    }
}