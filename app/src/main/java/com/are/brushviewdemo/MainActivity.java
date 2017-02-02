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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.are.brushview.BrushView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BrushView brushView;
    private AppCompatSeekBar seekBarSize, seekBarAlpha;
    private TextView txtSize, txtAlpha;
    private GridView gridView;
    private ModelColors modelColors;
    private AdapterColors adapter;
    private ArrayList<ModelColors> itemsColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Getting Colors from resources and add to ArrayList
         */

        int[] col = getResources().getIntArray(R.array.colors);
        itemsColors = new ArrayList<ModelColors>();
        for(int i = 0; i < col.length; i++){
            ModelColors model = new ModelColors();
            model.setColor(col[i]);
            itemsColors.add(model);
        }


        /**
         * Initialize Views
         */
        brushView = (BrushView) findViewById(R.id.brushView);

        seekBarSize = (AppCompatSeekBar) findViewById(R.id.seekBarSize);
        seekBarAlpha = (AppCompatSeekBar) findViewById(R.id.seekBarAlpha);

        txtSize = (TextView) findViewById(R.id.textViewBrushSize);
        txtAlpha = (TextView) findViewById(R.id.textViewBrushAlpha);

        gridView = (GridView) findViewById(R.id.gridViewColors);

        /**
         * SeekBar Listeners
         */
        seekBarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSize.setText(String.valueOf(progress));
                brushView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAlpha.setText(String.valueOf(progress));
                brushView.setAlphaValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                brushView.setColor(itemsColors.get(position).getColor());
            }
        });

        adapter = new AdapterColors(this, itemsColors);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
