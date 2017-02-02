# BrushView
  
  Simple View to change Brush Size, Alpha and Color

### Screenshots
<img src="https://github.com/Andreu35/BrushView/blob/master/screenshots/Screenshot_20170202-171734.png" width="170px" height="300px"/>  <img src="https://github.com/Andreu35/BrushView/blob/master/screenshots/Screenshot_20170202-171741.png" width="170px" height="300px"/>  <img src="https://github.com/Andreu35/BrushView/blob/master/screenshots/Screenshot_20170202-171746.png" width="170px" height="300px"/>  <img src="https://github.com/Andreu35/BrushView/blob/master/screenshots/Screenshot_20170202-171801.png" width="170px" height="300px"/>

# How to install
  
  In your build.gradle project
  
```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
  In your build.gradle app
  
```java
dependencies {
    ...
    compile 'com.github.Andreu35:BrushView:v.1.0'
    ...
}
```

# How to use

  In your layout.xml
  
```java
<com.are.brushview.BrushView
  android:id="@+id/brushView"
  android:layout_width="220dp"
  android:layout_height="220dp"
  android:layout_gravity="center"
  android:layout_margin="20dp"
    app:brush_size="50"
    app:brush_alpha="255"
    app:brush_color="@color/colorPrimary"/>
```

  In your Activity.java
  
```java
public class MainActivity extends AppCompatActivity {
    private BrushView brushView;
    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initialize Views
         */
        brushView = (BrushView) findViewById(R.id.brushView);
        ...
        
        /**
         * SeekBar Listeners
         */
        seekBarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSize.setText(String.valueOf(progress));
                brushView.setRadius(progress);
            }
        });

        seekBarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAlpha.setText(String.valueOf(progress));
                brushView.setAlphaValue(progress);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                brushView.setColor(itemsColors.get(position).getColor());
            }
        });
    }
}
```
### App using BrushView
<a href="https://play.google.com/store/apps/details?id=com.are.cards"><img src="https://lh3.googleusercontent.com/KHZIzUQwO4HkqYaJvcn9QlbOcA7fd01BD6Pqli__qSqRmyvQi0j6r2-J1S4AAZOIE6e6=w300-rw" width="50px" height="50px"></a></br>  Cards

### License

    Copyright (C) 2017 Andreu35

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
