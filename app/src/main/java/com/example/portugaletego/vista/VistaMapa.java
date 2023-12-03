package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.portugaletego.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;


public class VistaMapa extends AppCompatActivity {

    MapView map;
    IMapController mapController;
    private static final String TAG = "OsmActivity";


    Button botonMinijuego1;
    Button botonMinijuego2;
    Button botonMinijuego3;
    Button botonMinijuego4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_vista_mapa);

        map = findViewById(R.id.mapaGPS);
        // map.setTileSource(TileSourceFactory.MAPNIK);
        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(18.0);
        GeoPoint geoPoint = new GeoPoint(43.3186569, -3.0219986);
        mapController.setCenter(geoPoint);

        //your items
        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
        items.add(new OverlayItem("Puente Colgante", "El Puente de Vizcaya, también conocido como Puente Bizkaia, " +
                "Puente colgante, Puente de Portugalete, " +
                "o Puente colgante de Portugalete, es un puente transbordador de peaje, concebido, diseñado y " +
                "construido por iniciativa privada entre 1887 y 1893, que une las dos márgenes de la ría de Bilbao en Vizcaya.",
                new GeoPoint(43.32280702415836, -3.017871992540378))); // Lat/Lon decimal degrees

        //the overlay
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        Intent mandar = new Intent(VistaMapa.this, ventanaJuego1BizkaikoZubia.class);
                        startActivity(mandar);
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {

                        return false;
                    }
                }, this);
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);

        map.setUseDataConnection(true);


        botonMinijuego1 = findViewById(R.id.btnPC);
        botonMinijuego1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mandar = new Intent(VistaMapa.this, ventanaJuego1BizkaikoZubia.class);
                startActivity(mandar);
            }
        });

        botonMinijuego2 = findViewById(R.id.btnMJ2);
        botonMinijuego2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent mandar = new Intent(VistaMapa.this, ventanaJuego1BizkaikoZubia.class);
                startActivity(mandar);

                 */
            }
        });

        botonMinijuego3 = findViewById(R.id.btnMJ3);
        botonMinijuego3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent mandar = new Intent(VistaMapa.this, ventanaJuego1BizkaikoZubia.class);
                startActivity(mandar);

                 */
            }
        });

        botonMinijuego4 = findViewById(R.id.btnMJ4);
        botonMinijuego4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent mandar = new Intent(VistaMapa.this, ventanaJuego1BizkaikoZubia.class);
                startActivity(mandar);

                 */
            }
        });

    }

    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        //if (map != null)
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }

    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        //if (map != null)
        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }


}