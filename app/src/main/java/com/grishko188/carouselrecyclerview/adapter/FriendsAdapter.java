package com.grishko188.carouselrecyclerview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grishko188.carouselrecyclerview.R;
import com.grishko188.carouselrecyclerview.model.Friend;
import com.grishko188.carouselrecyclerview.utils.CircleTransform;
import com.grishko188.carouselrecyclerview.utils.ConvertUtil;
import com.grishko188.carouselrecyclerview.utils.PlaceHolder;
import com.grishko188.carouselrecyclerview.view.FriendsView;
import com.grishko188.library.CarouselRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 11.08.2016.
 */
public class FriendsAdapter extends CarouselRecyclerView.Adapter {

    private final Context context;
    private final List<Friend> items;
    private int diameter;
    private Drawable placeholder;

    private final static CircleTransform TRANSFORMATION = new CircleTransform();

    public FriendsAdapter(Context context, List<Friend> items) {
        this.context = context;
        this.items = items;
        this.diameter = (int) ConvertUtil.px2dp(context, 78);
        this.placeholder = PlaceHolder.round(context.getResources().getColor(R.color.grey), diameter);
    }

    @Override
    public CarouselRecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CarouselRecyclerView.ViewHolder(new FriendsView(context));
    }

    @Override
    public void onBindViewHolder(CarouselRecyclerView.ViewHolder viewHolder, final int position) {
        FriendsView cardTestView = (FriendsView) viewHolder.itemView;
        final Friend item = items.get(position);

        TextView nameTextView = (TextView) cardTestView.findViewById(R.id.name);
        TextView emailTextView = (TextView) cardTestView.findViewById(R.id.email);
        TextView statusTextView = (TextView) cardTestView.findViewById(R.id.status);
        ImageView photoImageView = (ImageView) cardTestView.findViewById(R.id.photo);

        nameTextView.setText(item.getFullName());
        emailTextView.setText(item.getEmail());
        statusTextView.setText(item.isOnline() ? R.string.online : R.string.offline);

        if (item.hasPhoto()) {
            Picasso.with(context).load(item.getPhoto())
                    .resize(diameter, diameter).centerCrop()
                    .placeholder(placeholder)
                    .error(placeholder)
                    .transform(TRANSFORMATION)
                    .into(photoImageView);
        } else {
            photoImageView.setImageDrawable(placeholder);
        }

    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
