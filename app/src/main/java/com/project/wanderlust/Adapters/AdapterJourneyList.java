package com.project.wanderlust.Adapters;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.wanderlust.DataClasses.JourneyMini;
import com.project.wanderlust.R;
import com.project.wanderlust.Others.SharedFunctions;

import java.util.ArrayList;

public class AdapterJourneyList extends RecyclerView.Adapter<AdapterJourneyList.ViewHolderJourney>
{
    private ArrayList<JourneyMini> items;
    private Bitmap userPic;
    private String userName;
    private int itemLayout;

    public AdapterJourneyList(ArrayList<JourneyMini> journeys, Bitmap userPic, String userName, int itemLayout)
    {
        this.items = journeys;
        this.userPic = userPic;
        this.userName = userName;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolderJourney onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolderJourney(v);
    }


    @Override
    public void onBindViewHolder(ViewHolderJourney holder, int position)
    {
        if(items != null && holder != null)
        {
            JourneyMini item = items.get(position);

            holder.photo.setImageBitmap(userPic);
            holder.userName.setText(userName);
            holder.location.setText(item.location);
            holder.date.setText((SharedFunctions.months[item.date.getMonth() - 1] + " " + item.date.getDate()));
            holder.title.setText(item.title);

            ImageView imageView = holder.journeyPic;

            // journey photo
            if(item.bitmap != null)
            {
                imageView.setImageBitmap(item.bitmap);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(View.VISIBLE);
            }
            else
            {
                imageView.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public int getItemCount()
    {
        if(items != null)
            return items.size();
        else
            return 0;
    }


    class ViewHolderJourney extends RecyclerView.ViewHolder
    {
        public ImageView photo;
        public TextView userName;
        public TextView location;
        public TextView date;
        public TextView title;
        public ImageView journeyPic;

        public ViewHolderJourney(View view)
        {
            super(view);

            photo = view.findViewById(R.id.photo);
            userName = view.findViewById(R.id.userName);
            location = view.findViewById(R.id.location);
            date = view.findViewById(R.id.date);
            title = view.findViewById(R.id.title);
            journeyPic = view.findViewById(R.id.journeyPic);
        }
    }
}



