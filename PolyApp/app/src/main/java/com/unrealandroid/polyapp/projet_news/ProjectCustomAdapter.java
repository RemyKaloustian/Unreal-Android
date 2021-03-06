package com.unrealandroid.polyapp.projet_news;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.unrealandroid.polyapp.AsyncTaskImage;
import com.unrealandroid.polyapp.AsyncTaskImageSmart;
import com.unrealandroid.polyapp.R;
import com.unrealandroid.polyapp.event.SingleEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Charly on 04/04/2016.
 */
public class ProjectCustomAdapter extends ArrayAdapter<Project>{

    private Project project;

    public ProjectCustomAdapter(Context context, int resource, List<Project> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.project_preview, null);
        }

        project = getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.projectTitle);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageProject);

        TextView info = (TextView) convertView.findViewById(R.id.projectContentPreview);

        if(project.getBitmap() == null)
        {
            AsyncTaskImageSmart asyncTaskImage = new AsyncTaskImageSmart(image, project);
            asyncTaskImage.execute(project.getImage());
        }
        else
        {
            image.setImageBitmap(project.getBitmap());
        }

        title.setText(project.getTitle());

        info.setText(project.getContent());

        return convertView;
    }
}
