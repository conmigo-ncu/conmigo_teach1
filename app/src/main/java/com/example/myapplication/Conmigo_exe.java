package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Conmigo_exe#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class Conmigo_exe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    Text_select text_select;
   // ListView list_view;
    String[] items = {"無", "宜蘭二日遊", "桃園一日遊", "花東之旅"};
    int flag=0;
    Button sch_ing;

    public Conmigo_exe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
    // * @param param2 Parameter 2.
     * @return A new instance of fragment Conmigo_exe.
     */
    // TODO: Rename and change types and number of parameters
    /*public static Conmigo_exe newInstance(String param1, String param2) {
        Conmigo_exe fragment = new Conmigo_exe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
       // }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.conmigo_home, container, false);

        Button mySchedule = v.findViewById(R.id.my_schedule);
       // ImageButton mySchedule_bottom = v.findViewById(R.id.schedule);
        //ImageButton user_bottom = v.findViewById(R.id.user_page);
        mySchedule.setOnClickListener(btnToMySchedule);
        //mySchedule_bottom.setOnClickListener(btnToMySchedule_bottom);
        //user_bottom.setOnClickListener(btnToUser_bottom);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_text, R.id.text, items);

        sch_ing = v.findViewById(R.id.now);
        sch_ing.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alert_dialog = new AlertDialog.Builder(getActivity());
                //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_text, R.id.text, items);
                //View list = getLayoutInflater().inflate(R.layout.list_view_ing, null);
               // list_view = list.findViewById(R.id.sch_list);
                //list_view.setAdapter(adapter);
                alert_dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(items[which] == "無"){
                            sch_ing.setText("當日行程");
                        }
                        else{
                            sch_ing.setText(String.valueOf(items[which]));
                        }

                        //text_select = new Text_select(getView());
                        //flag = which;
                       // text_select.notifyDataSetChanged();
                    }
                });
                /*alert_dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });   */
                //alert_dialog.setView(list_view);
                alert_dialog.show();
                //open_dialog(v);
                return true;
            }
        });


        sch_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.schdule_ing);
                ImageButton close = dialog.findViewById(R.id.closw_ing);
                ImageButton note = dialog.findViewById(R.id.note);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                note.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog note_dialog = new Dialog(getActivity());
                        note_dialog.setContentView(R.layout.schedule_ing_note);
                        Button comp = note_dialog.findViewById(R.id.complete);
                        comp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                note_dialog.dismiss();
                            }
                        });
                        note_dialog.show();
                    }
                });
                dialog.show();
            }
        });

        return v;
    }
    public class Text_select extends BaseAdapter{
        Context context;


        public Text_select(Context context){
            this.context = context;
        }

        @Override
        public int getCount(){
            return items.length;
        }

        @Override
        public Object getItem(int i){
            return items[i];
        }

        @Override
        public long getItemId(int i){
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            View text_view = View.inflate(context, R.layout.list_item_text, null);
            TextView sel_item = text_view.findViewById(R.id.text);
            if(flag == i){
                sel_item.setTextColor(getResources().getColor(R.color.green_text));
            }
            sel_item.setText(items[i]);

            return text_view;
        }
    }

    /*public void open_dialog(View v){
        AlertDialog.Builder alert_dialog = new AlertDialog.Builder(this.getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_view_ing, R.id.text, items);
        View list = getLayoutInflater().inflate(R.layout.list_view_ing, null);
        list_view = list.findViewById(R.id.sch_list);
        alert_dialog.setPositiveButton("確定", null);
        alert_dialog.setView(list_view);
        alert_dialog.show();

    }   */
    private  View.OnClickListener btnToMySchedule = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showMySchedule();
        }
    };
  /*  private  View.OnClickListener btnToMySchedule_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showMySchedule();
        }
    };
    private  View.OnClickListener btnToUser_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showPersonalPage();
        }
    };  */
}