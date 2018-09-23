package com.wooraekyong.bt2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.wooraekyong.bt2.R.id.textView_population;

public class CustomListAdapter extends BaseAdapter{
    private List<Place> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<Place> listData){
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item_layout_see,null);
            holder = new ViewHolder();
            holder.imagePlaceView = (ImageView) convertView.findViewById(R.id.imageView_place);
            holder.placenameView = (TextView) convertView.findViewById(R.id.textview_placename);
            holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        Place place = this.listData.get(position);
        holder.placenameView.setText(place.getPlaceName());
        holder.populationView.setText("Population: "+ place.getPopulation());

        int imageId = this.getMipmapResIdByName(place.getPlaceName());

        holder.imagePlaceView.setImageResource(imageId);

        return convertView;
    }
    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView","Res Name: "+ resName+"==> Res ID ="+resID);
        return resID;
    }

    static class ViewHolder {
        ImageView imagePlaceView;
        TextView placenameView;
        TextView populationView;

    }
}
