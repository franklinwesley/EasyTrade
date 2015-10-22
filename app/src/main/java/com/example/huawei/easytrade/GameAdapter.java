package com.example.huawei.easytrade;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huawei.easytrade.Model.Game;

import java.util.List;

/**
 * Created by huawei on 21/10/15.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder>  {
    private Context context;
    private List<Game> games;

    public GameAdapter(Context context, List<Game> games) {

        this.games = games;
        this.context = context;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        GameViewHolder contactViewHolder = new GameViewHolder(context, view);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {

        Game game = games.get(position);
        holder.name.setText(game.getName());
        holder.platform.setText(game.getPlatform());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }


    public class GameViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView platform;
        Context context;

        public GameViewHolder(Context context, View itemView) {
            super(itemView);

            this.context = context;

            //TODO mecher aki
        }
    }
}
