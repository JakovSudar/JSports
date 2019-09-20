package hr.ferit.sudar.jakov.jsports;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class InfoFragment extends Fragment {

    TextView textView;
    TextView title;
    ImageView imageView;
    RelativeLayout homeBtn;
    RelativeLayout randomBtn;
    RelativeLayout menuBtn;
    private  ButtonClickListener buttonClickListener;
    int position;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        setInfo(getArguments().getInt("position"));
        setListeners();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        buttonClickListener = (ButtonClickListener) context;
    }

    void setViews(View view){
        textView = view.findViewById(R.id.tvOpis);
        title = view.findViewById(R.id.tvTitle);
        imageView = view.findViewById(R.id.ivImage);

        homeBtn = view.findViewById(R.id.btnHome);
        randomBtn= view.findViewById(R.id.btnRandom);
        menuBtn = view.findViewById(R.id.btnMenu);
    }

    void setListeners(){
         homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListener.OnButtonClick("home");
            }
        });

         randomBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 buttonClickListener.OnButtonClick("random");
             }
         });

         menuBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 buttonClickListener.OnButtonClick("menu");
             }
         });

    }

    void setInfo(int position){
        switch (position){
            case 0 : imageView.setImageResource(R.drawable.nogomet);
                textView.setText(getResources().getString(R.string.nogomet));
                title.setText("NOGOMET");break;
            case 1 : imageView.setImageResource(R.drawable.rukomet);
                textView.setText(getResources().getString(R.string.rukomet));
                title.setText("RUKOMET");break;
            case 2 : imageView.setImageResource(R.drawable.kosarka);
                textView.setText(getResources().getString(R.string.kosarka));
                title.setText("KOŠARKA");break;
            case 3 : imageView.setImageResource(R.drawable.hokej);
                textView.setText(getResources().getString(R.string.hokej));
                title.setText("HOKEJ");break;
            case 4 : imageView.setImageResource(R.drawable.vaterpolo);
                textView.setText(getResources().getString(R.string.vaterpolo));
                title.setText("VATERPOLO");break;
            case 5 : imageView.setImageResource(R.drawable.badminton);
                textView.setText(getResources().getString(R.string.badminton));
                title.setText("BADMINTON");break;
            case 6 : imageView.setImageResource(R.drawable.sah);
                textView.setText(getResources().getString(R.string.sah));
                title.setText("ŠAH");break;
            case 7 : imageView.setImageResource(R.drawable.kriket);
                textView.setText(getResources().getString(R.string.kriket));
                title.setText("KRIKET");break;
            case 8 : imageView.setImageResource(R.drawable.golf);
                textView.setText(getResources().getString(R.string.golf));
                title.setText("GOLF");break;
            case 9 : imageView.setImageResource(R.drawable.tenis);
                textView.setText(getResources().getString(R.string.tenis));
                title.setText("TENIS");break;
            case 10: imageView.setImageResource(R.drawable.stolnitenis);
                textView.setText(getResources().getString(R.string.stolnitenis));
                title.setText("STOLNI TENIS");break;
            case 11: imageView.setImageResource(R.drawable.atletika);
                textView.setText(getResources().getString(R.string.atletika));
                title.setText("ATLETIKA");break;
            case 12:imageView.setImageResource(R.drawable.boks);
                textView.setText(getResources().getString(R.string.boks));
                title.setText("BOKS");break;
            case 13:imageView.setImageResource(R.drawable.bob);
                textView.setText(getResources().getString(R.string.bob));
                title.setText("BOB");break;
            case 14:imageView.setImageResource(R.drawable.pikado);
                textView.setText(getResources().getString(R.string.pikado));
                title.setText("PIKADO");break;
            case 15:imageView.setImageResource(R.drawable.kuglanje);
                textView.setText(getResources().getString(R.string.kuglanje));
                title.setText("KUGLANJE");break;
            case 16:imageView.setImageResource(R.drawable.biljar);
                textView.setText(getResources().getString(R.string.biljar));
                title.setText("BILJAR");break;
            case 17:imageView.setImageResource(R.drawable.bejzbol);
                textView.setText(getResources().getString(R.string.bejzbol));
                title.setText("BEJZBOL");break;
            case 18:imageView.setImageResource(R.drawable.kanu);
                textView.setText(getResources().getString(R.string.kanu));
                title.setText("KANU");break;
            case 19:imageView.setImageResource(R.drawable.veslanje);
                textView.setText(getResources().getString(R.string.veslanje));
                title.setText("VESLANJE");break;
            case 20:imageView.setImageResource(R.drawable.ronjenje);
                textView.setText(getResources().getString(R.string.ronjenje));
                title.setText("RONJENJE");break;
            case 21:imageView.setImageResource(R.drawable.plivanje);
                textView.setText(getResources().getString(R.string.plivanje));
                title.setText("PLIVANJE");break;
        }
    }
}

