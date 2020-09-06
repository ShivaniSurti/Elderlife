package com.example.elderlycaregamified;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.elderlycaregamified.ElderlyActivity.address1;
import static com.example.elderlycaregamified.ElderlyActivity.address2;
import static com.example.elderlycaregamified.ElderlyActivity.task1;
import static com.example.elderlycaregamified.ElderlyActivity.task2;
import static com.example.elderlycaregamified.TaskDialog.stickerIcon1;
import static com.example.elderlycaregamified.TaskDialog.stickerIcon2;
import static com.example.elderlycaregamified.YoungActivity.clickedMarker;

public class MapTasksActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {

            @Override
            public boolean onMarkerClick(Marker marker)
            {
                Intent intent = new Intent(MapTasksActivity.this, YoungActivity.class);
                intent.putExtra("TASK_NAME", marker.getTitle());
                intent.putExtra("LOCATION_NAME", marker.getSnippet());

                clickedMarker = true;

                startActivity(intent);

                return true;
            }
        });


        LatLng loc1 = getLocationFromAddress(getApplicationContext(), address1);
        LatLng loc2 = getLocationFromAddress(getApplicationContext(), address2);

        ArrayList<MarkerOptions> markers = new ArrayList<>();
        MarkerOptions marker1 = new MarkerOptions().position(loc1).title(task1).icon(BitmapDescriptorFactory.fromResource(stickerIcon1)).snippet(address1);
        MarkerOptions marker2 = new MarkerOptions().position(loc2).title(task2).icon(BitmapDescriptorFactory.fromResource(stickerIcon2)).snippet(address2);

        markers.add(marker1);
        markers.add(marker2);


        mMap.addMarker(marker1);
        mMap.addMarker(marker2);
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(loc1));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //For when we have multiple markers
        for (MarkerOptions marker : markers) {

            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 30; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        mMap.moveCamera(cu);
    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }


}
