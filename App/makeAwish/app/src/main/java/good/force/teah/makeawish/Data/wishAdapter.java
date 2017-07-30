package good.force.teah.makeawish.Data;

/**
 * Created by Sarbjit on 30-07-2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import good.force.teah.makeawish.R;

public class wishAdapter extends RecyclerView.Adapter<wishAdapter.MyViewHolder> {

    private List<wish> listData;
    private LayoutInflater inflater;

    public wishAdapter(List<wish> listData, Context c)
    {
        this.inflater=LayoutInflater.from(c);
        this.listData=listData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.wish_list_row,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        wish item=listData.get(position);
        holder.title.setText(item.getName());
        holder.icon.setImageResource(item.getImageResId());
        holder.status.setText(item.getStatus());
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView title,status;
        private ImageView icon;
        private View container;

        public MyViewHolder(View itemView) {
            super(itemView);

            title=(TextView) itemView.findViewById(R.id.childName);
            status=(TextView) itemView.findViewById(R.id.status);
            icon=(ImageView) itemView.findViewById(R.id.im_item_icon);
            container=itemView.findViewById(R.id.cont_item_root);


        }
    }
    }

