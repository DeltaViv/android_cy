package com.example.maibenben.mywechat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

//
//public class adapter extends RecyclerView.Adapter<adapter.myviewholder> {
//
//    private List<StickyData>list;
//    private Context context;
//    private View inflater;
//
//    public static final int FIRST_STICKY_VIEW = 1;
//    public static final int HAS_STICKY_VIEW = 2;
//    public static final int NONE_STICKY_VIEW = 3;
//
//    public adapter(Context context,List<StickyData>list) {
//        this.context=context;
//        this.list=list;
//    }
//
//    @Override
//    public myviewholder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        inflater= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
//        myviewholder myviewholder=new myviewholder(inflater);
//        return myviewholder;
//    }
//
//    @Override
//    public void onBindViewHolder(myviewholder myviewholder, int position) {
//
//        StickyData stickyData=list.get(position);
//        myviewholder.tvTeam.setText(stickyData.getTeam());
//
//        if (position == 0) {
//            myviewholder.tvArea.setVisibility(View.VISIBLE);
//            myviewholder.tvArea.setText(stickyData.area);
//            myviewholder.itemView.setTag(FIRST_STICKY_VIEW);
//        } else {
//            if (!TextUtils.equals(stickyData.area, list.get(position - 1).area)) {
//                myviewholder.tvArea.setVisibility(View.VISIBLE);
//                myviewholder.tvArea.setText(stickyData.area);
//                myviewholder.itemView.setTag(HAS_STICKY_VIEW);
//            } else {
//                myviewholder.tvArea.setVisibility(View.GONE);
//                myviewholder.itemView.setTag(NONE_STICKY_VIEW);
//            }
//        }
//        myviewholder.itemView.setContentDescription(stickyData.area);
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    class myviewholder extends RecyclerView.ViewHolder{
//        TextView tvArea,tvTeam;
//        public myviewholder(View itemView) {
//            super(itemView);
//            tvArea= (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
//            tvTeam = (TextView) itemView.findViewById(R.id.tv_team);
//        }
//    }
//}

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {
    private List<Peaky> list;
    private View inflater;

    public Adapter(List<Peaky> peakyList) {
        list = peakyList;
    }

    @Override
    public Adapter.myviewholder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        inflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        myviewholder myviewholder = new myviewholder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(Adapter.myviewholder holder, int position) {
        Peaky peaky = list.get(position);
        holder.peakyImage.setImageResource(peaky.getImageid());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        View peakyView;
        ImageView peakyImage;
        public myviewholder( View itemView) {
            super(itemView);
            peakyView = itemView;
            peakyImage = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}

