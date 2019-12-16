package me.bilalhaider.moviedatabase.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.bilalhaider.moviedatabase.R;
import me.bilalhaider.moviedatabase.data.model.SearchItemResponse;
import me.bilalhaider.moviedatabase.ui.movie.MovieActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.SearchVH> {

    private ArrayList<SearchItemResponse> mSearchItems;
    private Context mContext;

    HomeAdapter(Context context, ArrayList<SearchItemResponse> searchItemResponse) {
        this.mContext = context;
        this.mSearchItems = searchItemResponse;
    }

    @NonNull
    @Override
    public SearchVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_search_results, parent, false);

        return new SearchVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchVH holder, int position) {
        SearchItemResponse searchItemResponse = mSearchItems.get(position);

        if (searchItemResponse.getTitle() != null) {
            holder.movieTitle.setText(searchItemResponse.getTitle());

            holder.movieTitle.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, MovieActivity.class);
                intent.putExtra("IMDBID", searchItemResponse.getImdbID());
                mContext.startActivity(intent);
            });
        }

    }

    @Override
    public int getItemCount() {
        return mSearchItems.size();
    }

    class SearchVH extends RecyclerView.ViewHolder {

        @BindView(R.id.movieTitle)
        TextView movieTitle;

        SearchVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
