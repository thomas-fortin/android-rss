package fr.unicaen.info.dnr2i.rssapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static fr.unicaen.info.dnr2i.rssapplication.R.mipmap.ic_launcher;

/**
 * Created by thomas on 25/01/17.
 */

public class RssItemAdapter extends ArrayAdapter<RssItem> {

    public RssItemAdapter(Context context, int resource, List<RssItem> feeds) {
        super(context, resource, feeds);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rss_item_list, parent, false);
        }

        RssItemViewHolder rssItemViewHolder = (RssItemViewHolder) convertView.getTag();

        if (rssItemViewHolder == null) {
            rssItemViewHolder = new RssItemViewHolder();
            rssItemViewHolder.image = (ImageView) convertView.findViewById(R.id.imageRssItemImage);
            rssItemViewHolder.title = (TextView) convertView.findViewById(R.id.textViewRssItemName);
            rssItemViewHolder.link = (TextView) convertView.findViewById(R.id.textViewRssItemLink);
            rssItemViewHolder.description = (TextView) convertView.findViewById(R.id.textViewRssItemDescription);

            convertView.setTag(rssItemViewHolder);
        }

        RssItem rssItem = getItem(position);

        rssItemViewHolder.image.setImageResource(ic_launcher);
        rssItemViewHolder.title.setText(rssItem.getTitle());
        rssItemViewHolder.link.setText(rssItem.getLink());
        rssItemViewHolder.description.setText(rssItem.getDescription());

        return convertView;
    }

    public class RssItemViewHolder {
        public TextView title;
        public TextView link;
        public TextView description;
        public ImageView image;
    }
}
