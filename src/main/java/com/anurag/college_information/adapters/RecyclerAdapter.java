package com.anurag.college_information.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anurag.college_information.models.ModelClass;
import com.anurag.college_information.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<ModelClass> collegeList ;
    private RecyclerViewClickListener listener;


    public RecyclerAdapter(List<ModelClass> collegeList, RecyclerViewClickListener listener){
        this.collegeList=collegeList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_list_single_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        int img = collegeList.get(position).getCollegeImage();
        String cName = collegeList.get(position).getCollegeName();
        String cRating = collegeList.get(position).getCollegeRating();

        holder.setData(img, cName, cRating);

    }

    @Override
    public int getItemCount() {
        return collegeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView collegeName, collegeRating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.college_image);
            collegeName = itemView.findViewById(R.id.college_name);
            collegeRating = itemView.findViewById(R.id.college_rating);

            itemView.setOnClickListener(this);

        }

        public void setData(int img, String cName, String cRating) {

            imageView.setImageResource(img);
            collegeName.setText(cName);
            collegeRating.setText(cRating);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }

    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
