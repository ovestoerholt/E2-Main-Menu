package no.inforte.android.hovedmeny;

/**
 * Created by Rune on 20.10.13.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class GoalListArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public GoalListArrayAdapter(Context context, String[] values) {
        super(context, R.layout.goal_list_row, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // *********************** GET ROW ************************
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.goal_list_row, parent, false);


        // *********************** SET TITLE TEXTVIEW ************************
        TextView textView = (TextView) rowView.findViewById(R.id.goalLabel);
        textView.setText(values[position]);


        // ********************** GET SCORE DISPLAY ***************************
        final TextView scoreDisplay = (TextView) rowView.findViewById(R.id.scoreDisplay);


        // *********************** HANDLE SEEK BAR CHANGES *********************
        final SeekBar seekGoalScore = (SeekBar) rowView.findViewById(R.id.seekGoalScore);
        seekGoalScore.setProgress(10);
        scoreDisplay.setText("0");
        seekGoalScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scoreDisplay.setText(String.valueOf(progress-10));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        return rowView;
    }
}
