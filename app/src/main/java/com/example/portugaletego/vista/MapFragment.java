package com.example.portugaletego.vista;

import static com.google.common.reflect.Reflection.getPackageName;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    MapView map;
    IMapController mapController;
    private static final String TAG = "OsmActivity";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View vista;
    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_map, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance){
        super.onViewCreated(view, savedInstance);

        Context ctx = getContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().setUserAgentValue(view.getContext().getPackageName());

        map = vista.findViewById(R.id.mapaGPS);
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

        items.add(new OverlayItem("Museo Rialia", "Según documentos conservados en el Archivo Histórico de Portugalete, " +
                "ya en el año 1892 competía una trainera de Portugalete en la regata entre cofradías, " +
                "y por lo tanto ya no podemos considerar como primera constancia escrita aquella que habla de una tripulación local compitiendo en 1917. " +
                "Es en 1917 cuando se inician las regatas del Abra, quedando las tripulaciones en el orden siguiente: " +
                "Santurtzi, Portugalete, Zierbena y Algorta. La trainera portugaluja se llamaba “Engracia“.",
                new GeoPoint(43.318723256749124, -3.0140295609217365))); // Lat/Lon decimal degrees

        items.add(new OverlayItem("Torre Salazar", "La casa torre de Salazar, es una casa torre del siglo xiv, " +
                "construida hacia 1380 en mampostería y se sitúa en la Villa de Portugalete (Vizcaya). " +
                "Perteneció al linaje de los Salazar. ",
                new GeoPoint(43.320139896048985, -3.0170681032500877))); // Lat/Lon decimal degrees

        items.add(new OverlayItem("Campo de Futbol La Florida", "según las fuentes históricas consultadas, remonta sus orígenes a 1909 cuando es fundado por su primer Presidente, " +
                "Alfredo Hervias, y se federa con el nombre de Deportivo Portugalete.\n" +
                "A partir de ese nacimiento, pasamos a exponer los datos más relevantes y/o anecdóticos de la Historia del Club, cronológicamente ordenados por sus décadas de vida, " +
                "y estableciendo un bonito paralelismo con la situación de la Noble Villa de Portugalete en cada época.",
                new GeoPoint(43.31826126075431, -3.026257332581579))); // Lat/Lon decimal degrees

        //the overlay

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> hola =  new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>(){
            @Override
            public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(final int index, final OverlayItem item) {
                if (item.getTitle().equals("Puente Colgante")) {
                    Intent mandar = new Intent(getActivity(), ventanaJuego1BizkaikoZubia.class);
                    startActivity(mandar);
                }
                return false;
            }
        };
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items , hola, view.getContext());
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);

        map.setUseDataConnection(true);
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

}