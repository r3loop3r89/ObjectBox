package com.example.shrawanwable.objectbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shrawanwable.objectbox.R;
import com.example.shrawanwable.objectbox.models.LocationEntry;

import org.joda.time.DateTime;

import java.util.List;

public class LocationEntryDetailsListAdapter extends BaseAdapter {
    Context mCtx;
    List<LocationEntry> locationEntries;

    public LocationEntryDetailsListAdapter(Context mCtx, List<LocationEntry> locationEntries) {
        this.mCtx = mCtx;
        this.locationEntries = locationEntries;
    }

    @Override
    public int getCount() {
        return locationEntries.size();
    }

    @Override
    public Object getItem(int position) {
        return locationEntries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LEDLAViewHolder h;
        if (v == null) {
            v = LayoutInflater.from(mCtx).inflate(R.layout.location_entry_details_list_item_layout, parent, false);
            h = new LEDLAViewHolder(v);
            v.setTag(h);
        } else {
            h = (LEDLAViewHolder) v.getTag();
        }

        LocationEntry e = (LocationEntry) getItem(position);
        h.tvLEDLILSrNo.setText("" + e.getLeid());
        h.tvLEDLILLatLong.setText("" + e.getLatitude() + "\n" + e.getLongitude());
        DateTime dateTime = new DateTime(e.getEntryOnEpoch());
        h.tvLEDLILTime.setText(dateTime.toString(mCtx.getResources().getString(R.string.time_format)));
        h.tvLEDLILBatteryLevel.setText("" + e.getBatteryLevel() + "%");
        return v;
    }

    static class LEDLAViewHolder {
        private TextView tvLEDLILSrNo;
        private TextView tvLEDLILTime;
        private TextView tvLEDLILLatLong;
        private TextView tvLEDLILBatteryLevel;

        public LEDLAViewHolder(View v) {
            tvLEDLILSrNo = v.findViewById(R.id.tvLEDLILSrNo);
            tvLEDLILTime = v.findViewById(R.id.tvLEDLILTime);
            tvLEDLILLatLong = v.findViewById(R.id.tvLEDLILLatLong);
            tvLEDLILBatteryLevel = v.findViewById(R.id.tvLEDLILBatteryLevel);
        }
    }
}
