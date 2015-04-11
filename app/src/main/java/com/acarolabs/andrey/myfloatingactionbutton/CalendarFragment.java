package com.acarolabs.andrey.myfloatingactionbutton;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarCellDecorator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //int position = FragmentPagerItem.getPosition(getArguments());
        //TextView title = (TextView) view.findViewById(R.id.item_title);
        //title.setText("nose " + position);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) view.findViewById(R.id.calendar_view);
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 4, 30);

        List<Date> dates = new ArrayList<>();
        dates.add(today);
        dates.add(cal.getTime());


        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);
        calendar.highlightDates(dates);

        List<CalendarCellDecorator> decorators = new ArrayList<>();
        decorators.add(new SampleDecorator());
        calendar.setDecorators(decorators);


        //calendar.setBackgroundColor(Color.CYAN);
    }

    public class SampleDecorator implements CalendarCellDecorator {
        @Override
        public void decorate(CalendarCellView cellView, Date date) {
//            String dateString = Integer.toString(date.getDate());
//            SpannableString string = new SpannableString(dateString + "\nA");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                cellView.setBackgroundColor(Color.LTGRAY);
            }
            if(c.get(Calendar.DAY_OF_MONTH) == 5){
                cellView.setBackgroundColor(Color.RED);
                cellView.setTextColor(Color.WHITE);
            }
//            string.setSpan(new RelativeSizeSpan(0.5f), 0, dateString.length(),
//                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//            cellView.setText(string);
        }
    }


}
