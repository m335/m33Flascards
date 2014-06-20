/**@author Fabienne Pfister
 * @version V3
 */
package com.tbz.flashcards;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class InteractiveArrayAdapter extends ArrayAdapter<Model> {

  private final List<Model> paths;
  private final Activity context;

  public InteractiveArrayAdapter(Activity context, List<Model> paths) {
    super(context, R.layout.checkboxbutton, paths);
    this.context = context;
    this.paths = paths;
  }

  static class ViewHolder {
    protected TextView text;
    protected CheckBox checkbox;
  }

  //Grundriss für die Checkbox setzten
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = null;
    if (convertView == null) {
      LayoutInflater inflator = context.getLayoutInflater();
      view = inflator.inflate(R.layout.checkboxbutton, null);
      final ViewHolder viewHolder = new ViewHolder();
      viewHolder.text = (TextView) view.findViewById(R.id.label);
      viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
      viewHolder.checkbox
          .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        	  //Checkbox "anwählen"
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
              Model element = (Model) viewHolder.checkbox
                  .getTag();
              element.setSelected(buttonView.isChecked());

            }
          });
      view.setTag(viewHolder);
      viewHolder.checkbox.setTag(paths.get(position));
    } else {
      view = convertView;
      ((ViewHolder) view.getTag()).checkbox.setTag(paths.get(position));
    }
    ViewHolder holder = (ViewHolder) view.getTag();
    holder.text.setText(paths.get(position).getName());
    holder.checkbox.setChecked(paths.get(position).isSelected());
    return view;
  }
} 