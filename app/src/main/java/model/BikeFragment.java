package model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsmontreal.finalexammarlonescobar.MainActivity;
import com.appsmontreal.finalexammarlonescobar.R;

public class BikeFragment extends android.app.Fragment implements View.OnClickListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bike_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bike aBike = (Bike) getArguments().getSerializable(MainActivity.KEY);

        TextView textViewBBrand = getActivity().findViewById(R.id.textViewBBrand);
        textViewBBrand.setText(aBike.getBrand());
        TextView textViewBType = getActivity().findViewById(R.id.textViewBType);
        textViewBType.setText(aBike.getBikeType());
        TextView textViewBPrice = getActivity().findViewById(R.id.textViewBPrice);
        textViewBPrice.setText(String.valueOf(aBike.getPrice()));
        int resourceId = getResources().getIdentifier("drawable/" + aBike.getPictureId(),null,getActivity().getPackageName());
        ImageView imageView = getActivity().findViewById(R.id.imageViewBike);
        imageView.setImageResource(resourceId);

        Button exitButton = getActivity().findViewById(R.id.exitButtonBike);
        exitButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exitButtonBike){
            getActivity().finish();

        }

    }
}
