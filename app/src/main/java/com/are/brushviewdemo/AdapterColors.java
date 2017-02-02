/**
 *   Copyright (C) 2017 Andreu35
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.are.brushviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Andres on 01/02/2017.
 */

public class AdapterColors extends BaseAdapter {
    private Context context;
    private ArrayList<ModelColors> items;

    public AdapterColors(Context context, ArrayList<ModelColors> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items != null && items.size() > 0){
            return items.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.colors_layout, parent, false);

            holder.img = (ImageView) convertView.findViewById(R.id.imageViewColors);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setBackgroundColor(items.get(position).getColor());

        return convertView;
    }

    public static class ViewHolder{
        public ImageView img;
    }


}
