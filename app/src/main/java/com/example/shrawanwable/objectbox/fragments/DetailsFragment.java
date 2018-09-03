package com.example.shrawanwable.objectbox.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.adapters.LocationEntryDetailsListAdapter;
import com.example.shrawanwable.objectbox.models.LocationEntry;
import com.example.shrawanwable.objectbox.models.LocationEntry_;

import org.joda.time.DateTime;

import java.util.List;

import static com.example.shrawanwable.objectbox.App.DATEFORMAT;
import static com.example.shrawanwable.objectbox.App.locationEntryBox;

public class DetailsFragment extends Fragment {

    private static DetailsFragment INSTANCE = null;
    Context mCtx;
    DateTime dateTime;
    private ImageButton ibDSLPrev;
    private TextView tvDSLDate;
    private ImageButton ibDSLNext;
    private ListView lvDFList;

    public static DetailsFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DetailsFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.details_fragment, container, false);

        initViews(v);

        dateTime = new DateTime();
        loadDataForDate();

        ibDSLPrev.setOnClickListener(b -> {
            dateTime = dateTime.minusDays(1);
            loadDataForDate();
        });

        tvDSLDate.setOnClickListener(tv->{
            dateTime=new DateTime();
            loadDataForDate();
        });

        ibDSLNext.setOnClickListener(b->{
            dateTime=dateTime.plusDays(1);
            loadDataForDate();
        });

        return v;
    }

    private void loadDataForDate() {
        tvDSLDate.setText(dateTime.toString(DATEFORMAT));

        DateTime from = dateTime;
        from = from.withHourOfDay(00);
        from = from.withMinuteOfHour(00);
        from = from.withSecondOfMinute(00);
        from = from.withMillisOfSecond(00);

        DateTime to = dateTime;
        to = to.withHourOfDay(23);
        to = to.withMinuteOfHour(59);
        to = to.withSecondOfMinute(59);
        to = to.withMillisOfSecond(999);

        List<LocationEntry> locationEntries = locationEntryBox.query()
                .between(LocationEntry_.entryOnEpoch,
                        from.getMillis(),
                        to.getMillis())
                .build()
                .find();
        LocationEntryDetailsListAdapter
                adapter = new LocationEntryDetailsListAdapter(mCtx, locationEntries);
        lvDFList.setAdapter(adapter);
    }

    private void initViews(View v) {
        ibDSLPrev = v.findViewById(R.id.ibDSLPrev);
        tvDSLDate = v.findViewById(R.id.tvDSLDate);
        ibDSLNext = v.findViewById(R.id.ibDSLNext);
        lvDFList = v.findViewById(R.id.lvDFList);
    }
}
