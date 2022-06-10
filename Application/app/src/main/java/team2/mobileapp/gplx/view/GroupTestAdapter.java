package team2.mobileapp.gplx.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.dto.GroupTestItem;

class GroupTestAdapter extends ArrayAdapter<GroupTestItem> {

    private Activity context;
    public GroupTestAdapter(Activity context, int layoutID, List<GroupTestItem>
            objects) {
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView =
                LayoutInflater.from(context).inflate(R.layout.listview_group_test_item, null,
                        false);

        GroupTestItem groupTestItem = getItem(position);
        TextView tvTitle = (TextView)
                convertView.findViewById(R.id.tv_title_group_test);
        TextView tvNum = (TextView)
                convertView.findViewById(R.id.tv_num_group_test);
        tvNum.setText("Gồm "+groupTestItem.getNum()+" câu");
        tvTitle.setText(groupTestItem.getName().split("-")[0]);
        return convertView;
    }
}