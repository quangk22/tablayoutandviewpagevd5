package org.o7planning.tablayoutandviewpagevd5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder>{
    private List<Actor> actorList;
    private Fragment fragment;
    public ActorAdapter(List<Actor> actorList, Fragment fragment) {
        this.actorList = actorList;
        this.fragment = fragment;
    }
    @NonNull
    @Override
    public ActorAdapter.ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorAdapter.ActorViewHolder holder, int position) {
        /** Set Value*/
        final Actor actor = actorList.get(position);
        holder.actorName.setText(actor.getActorName());
        holder.actorPhoto.setImageResource(actor.getActorPhotoId());
        /*Sự kiện click vào item*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), actor.getActorName().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class ActorViewHolder extends RecyclerView.ViewHolder {
        private TextView actorName;
        private ImageView actorPhoto;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            actorName = (TextView) itemView.findViewById(R.id.actor_name);
            actorPhoto = (ImageView) itemView.findViewById(R.id.actor_photo);

        }
    }
}
