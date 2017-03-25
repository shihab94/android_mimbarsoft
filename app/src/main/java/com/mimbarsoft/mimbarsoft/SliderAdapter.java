package com.mimbarsoft.mimbarsoft;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderHolder>{
    private List<SliderBean> listdata;
    private LayoutInflater inflater;

    //constructor
    public SliderAdapter(List<SliderBean> data, Context context){
        inflater = LayoutInflater.from(context);
        listdata = data;
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list,parent,false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderHolder holder, int position) {
        SliderBean item = listdata.get(position);
        holder.title.setText(item.getTitle());
        holder.project_image.setImageResource(item.getImageID());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class SliderHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView project_image;
        private View container;

        public SliderHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            project_image = (ImageView) itemView.findViewById(R.id.project_image);
            container = itemView.findViewById(R.id.list_item);
        }
    }
}
