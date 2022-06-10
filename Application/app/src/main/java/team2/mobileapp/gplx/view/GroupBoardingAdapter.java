package team2.mobileapp.gplx.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import team2.mobileapp.gplx.R;

public class GroupBoardingAdapter extends ArrayAdapter<GroupBoardingItem> {

    private Activity context;
    public GroupBoardingAdapter(Activity context, int layoutID, List<GroupBoardingItem>
            objects) {
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView =
                LayoutInflater.from(context).inflate(R.layout.listview_group_boarding_item, null,
                        false);

        GroupBoardingItem groupBoardingItem = getItem(position);
        TextView tvName = (TextView)convertView.findViewById(R.id.tv_title_group_test);
        TextView tvQuantity = (TextView) convertView.findViewById(R.id.tv_num_group_test);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image_type_board);
        tvName.setText(groupBoardingItem.getName());
        tvQuantity.setText("Gồm "+groupBoardingItem.getQuantity().toString()+" câu");
        try {
            int imageResource = context.getResources().getIdentifier(groupBoardingItem.getType().toLowerCase(), "drawable", context.getPackageName());
            Drawable res = context.getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        }
        catch (Exception e){

        }

        return convertView;
    }
}