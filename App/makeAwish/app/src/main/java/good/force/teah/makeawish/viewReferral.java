package good.force.teah.makeawish;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import good.force.teah.makeawish.Data.WishData;
import good.force.teah.makeawish.Data.wish;
import good.force.teah.makeawish.Data.wishAdapter;

public class viewReferral extends AppCompatActivity {

    private List<wish> wishList = new ArrayList<>();
    private RecyclerView recView;
    private wishAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_referral);
        Intent intent = getIntent();

        recView = (RecyclerView) findViewById(R.id.recycler_view);


        recView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter=new wishAdapter(WishData.getListData(),this);
        recView.setAdapter(mAdapter);
    }


}
