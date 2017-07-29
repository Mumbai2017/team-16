package good.force.teah.makeawish.Data;

/**
 * Created by Sarbjit on 30-07-2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import good.force.teah.makeawish.R;
/*
public class wishAdapter extends RecyclerView.Adapter<wishAdapter.MyViewHolder> {

        private List<wishAdapter> wishList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, year, genre;

            public MyViewHolder(View view) {
                super(view);
                 = (TextView) view.findViewById(R.id.);
                 = (TextView) view.findViewById(R.id.);
                 = (TextView) view.findViewById(R.id.);
            }
        }


    public wishAdapter(List<wish> wishList) {
        this.wishList = wishList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wish_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        wish wishwish = wishList.get(position);
        holder.title.setText(wishwish.getTitle());
        holder.genre.setText(wishwish.getGenre());
        holder.year.setText(wishwish.getYear());
    }

    @Override
    public int getItemCount() {
        return wishList.size();
    }
    }

*/