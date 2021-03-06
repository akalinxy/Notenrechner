//package com.linxy.gradeorganizer.adapters;
//
//import android.graphics.PorterDuff;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.linxy.gradeorganizer.R;
//import com.linxy.gradeorganizer.objects.SubAvg;
//
//import java.util.List;
//
///**
// * Created by Linxy on 11/8/2015 at 10:03
// * Working on Grade Organizer in com.linxy.gradeorganizer.com.linxy.adapters
// */
//public class SRVAdapter extends RecyclerView.Adapter<SRVAdapter.AverageViewHolder> {
//
//
//    public static class AverageViewHolder extends RecyclerView.ViewHolder {
//        LinearLayout container;
//        TextView subjectName;
//        ImageView subjectGradeIcon;
//        TextView subjectAverage;
//
//        AverageViewHolder(View v) {
//            super(v);
//            container = (LinearLayout) v.findViewById(R.id.gl_container);
//            subjectName = (TextView) v.findViewById(R.id.gl_subname);
//            subjectGradeIcon = (ImageView) v.findViewById(R.id.gl_image);
//            subjectAverage = (TextView) v.findViewById(R.id.gl_subGrade);
//        }
//    }
//
//    List<SubAvg> sAverages;
//    public SRVAdapter(List<SubAvg> sAverages){
//        this.sAverages = sAverages;
//    }
//
//    @Override
//    public int getItemCount(){
//        return sAverages.size();
//    }
//
//    @Override
//    public AverageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grades_list, viewGroup, false);
//        AverageViewHolder avh  = new AverageViewHolder(v);
//        return avh;
//    }
//
//    @Override
//    public void onBindViewHolder(AverageViewHolder averageViewHolder, int i){
//        averageViewHolder.subjectName.setText(sAverages.get(i).subject);
//        averageViewHolder.subjectAverage.setText(sAverages.get(i).average);
//        averageViewHolder.subjectGradeIcon.setColorFilter(sAverages.get(i).color, PorterDuff.Mode.SRC_ATOP);
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView){
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//
//}
