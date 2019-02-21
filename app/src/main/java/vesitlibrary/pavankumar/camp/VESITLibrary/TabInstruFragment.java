package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 /**
 *
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import static vesitlibrary.pavankumar.camp.VESITLibrary.R.layout.list_item_book_display;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabInstruFragment extends Fragment {
    private ListView lv;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    // Search EditText
    EditText inputSearch;

    public TabInstruFragment() {
        // Required empty public constructor
    }
    Toolbar toolbar;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_instru, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }
        // Listview Data
        String products[] =
                {
                        "ADAPTIVE CONTROL 2/ED by \n ASTROM KARL J",
                        "AI & ROBOTICS INTRODUCTION by \n MURPHY R N",
                        "BIO-INSTRUMENTATION by \n WEBSTER J G (ED)",
                        "COMPUTER CONTROL OF PROCESSES by \n CHIDAMBARAM M",
                        "CONSTRUCTIVE NONLINEAR CONTROL by \n SEPULCHRE R",
                        "CONTROL & ITS APPLICATION by \n MILLER DANIEL E",
                        "CONTROL ENGINEERING by \n BANDOPADHYAY M",
                        "CONTROL SYSTEM THEORY by \n LYSBEVSKI S E",
                        "EMBEDDED MICROCONTROLLERS by \n MORTON T D",
                        "FUZZY CONTROL: AN INTRO  2/ED. by \n DRAIN KOV D",
                        "MODEL REDUCTION FOR FOR CONTROL SYS DES by \n OBINATO GORO",
                        "MODELING AND SIMULATION 2/ED by \n ZEIGLER BERNARD",
                        "NON LINEAR CONTROL SYS  3/ED by \n ISIDORI ALBERTO",
                        "NON LINEAR CONTROL SYS II by \n ISIDORI ALBERTO",
                        "NON LINEAR IDENTIFICATION & CONTROL by \n LIU G P",
                        "NON LINEAR MODEL BASED PROCESS CONTROL by \n ANSARI R M",
                        "NUMERICAL METH FOR STOCHASTIC CONTROL by \n KUSHNER H J",
                        "PROGRAMMABLE LOGIC CONTROLLER by \n HACKWORTH J R",
                        "PROGRAMMABLE LOGIC CONTROLLER 2/ED by \n DUNNING GARY",
                        "ROBOTICS INTRODUCTION 2/ED by \n CRAIG JOHN J",
                        "ROBUST CONTROL by \n DELLERUD G E",
                        "ROBUST CONTROL by \n REZA MOHEIMAMI",
                        "ROBUST CONTROL DESIGN USING H METHOD by \n PETERSEN IAN R",
                        "STOCHASTIC PROCESSES ESTIMATION by \n SARIDIS G N",
                        "UNIT OPERATIONS OF CHEMICAL ENGG 6/ED by \n MCCABE- SMITH",
                        "VARIABLE STRUCTURE SYS by \n YU ZINGHUO",
                        "123 ROBOTIC EXPERIMENTS by \n PREDKO MIKE",
                        "ADAPTIVE CONTROL by \n SASTRY SHANKAR",
                        "ADAPTIVE CONTROL by \n ASTROM K J",
                        "ADAPTIVE CONTROL 2/ED by \n ASTROM KARL J",
                        "ADAPTIVE CONTROL DESIGN AND ANALYSIS by \n TAO GANG",
                        "ADAPTIVE CONTROL SYSTEMS by \n CHALAM V V",
                        "ADVANCED CONTROL THEORY by \n MAJHI SOMANATH",
                        "ADVANCED INSTRUMENTATION AND COMPUTER I/O DESIGN by \n GARRETT PATRICK H",
                        "ADVANCED MATHEMATICAL TOOLS FOR AUTOMATIC CONTRO ENGINEERS by \n POZNYAK ALEXANDER S",
                        "ADVANCED PROCESS CONTROL by \n SMITH CECIL",
                        "AI & ROBOTICS INTRODUCTION by \n MURPHY R N"
                };

        lv = (ListView)  rootView.findViewById(R.id.list_view);
        inputSearch = (EditText)  rootView.findViewById(R.id.inputSearch);
        lv.setOnItemClickListener(onListClick);

        // Adding items to listview
        adapter = new ArrayAdapter<>(getActivity(), list_item_book_display, R.id.product_name, products);
        lv.setAdapter(adapter);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                TabInstruFragment.this.adapter.getFilter().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        return rootView;
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> parent, View view, int pos, long id){

            Intent i = new Intent(getActivity().getBaseContext(), BookDisplayInstruActivity.class);
            i.putExtra("idbyinstru", pos);
            startActivity(i);
        }
    };


}
