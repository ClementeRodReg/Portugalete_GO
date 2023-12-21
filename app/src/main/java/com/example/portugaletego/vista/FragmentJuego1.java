package com.example.portugaletego.vista;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentJuego1 extends Fragment {

    ImageView recogida;

    @Override
    public boolean onLongClick(View v) {

        recogida = (ImageView) v;

        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

        ClipData dragData = new ClipData((CharSequence) v.getTag(),
                new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                item);

        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

        v.startDragAndDrop(dragData,myShadow,null,0);

        return true;

    }

    View.OnDragListener drag = (v, event) -> {

        int dragEvent = event.getAction();

        switch (dragEvent) {

            case DragEvent.ACTION_DROP:

                if (v.getId() == R.id.idtv1 && recogida.getId() == R.id.idImagensiu) {

                    v.setBackground(recogida.getDrawable());

                    recogida.setVisibility(View.GONE);

                    Toast toast1 = Toast.makeText(getApplicationContext(),"BIEN", Toast.LENGTH_SHORT);
                    toast1.show();
                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(),"MAL", Toast.LENGTH_SHORT);
                    toast1.show();
                }

        }

        return true;

    };
}
