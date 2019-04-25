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

public class CarFragment extends android.app.Fragment implements View.OnClickListener {
    ImageView imageViewCar;
    Button exitButtonCar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.car_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageViewCar = getActivity().findViewById(R.id.imageViewCar);
        imageViewCar.setImageResource(R.drawable.under);
//        TextView textViewUnder = getActivity().findViewById(R.id.textViewUnder);

//
        exitButtonCar = getActivity().findViewById(R.id.exitButtonCar);
        exitButtonCar.setOnClickListener(this);
//
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exitButtonCar){
            getActivity().finish();

        }
//
    }
}
