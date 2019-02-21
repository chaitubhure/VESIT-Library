package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 /**
 * Created by Pavankumar Sakhare on for managing fragments TABCOMPUTER FRAGMENT
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
public class TabComputerFragment extends Fragment {
    private ListView lv;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    // Search EditText
    EditText inputSearch;

    public TabComputerFragment() {
        // Required empty public constructor
    }

    Toolbar toolbar;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_computer, container, false);


        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        // Listview Data
        String products[] =
                {       "ADVANCED MICROPROCESSORS & PERIPHERALS",
                        "ADVANCED MICROPROCESSORS 2/ED",
                        "ANALOG AND DIGITAL COMMUNICATION 3/ED",
                        "ARTIFICIAL INTELLIGENCE",
                        "AUTOMATICS CONTROL SYSTEMS 8/ED",
                        "BASIC RADIO & TELEVISION",
                        "BUSINESS COMMUNICATION 4/ED",
                        "BUSINESS DATA COMMUNICATION 5/ED",
                        "C PROGRAMMING TEST YOUR KNOWLEDGE",
                        "CLOUD COMPUTING",
                        "COMPUTER GRAPHICS WITH VR SYSTEMS",
                        "COMPUTER NETWORKS",
                        "COMPUTER ORGANIZATION & ARCHITECTURE 8/ED",
                        "CONTROL SYSTEM ENGINEERING 6/ED",
                        "CONTROL SYSTEMS ENGINEERING USING MATLAB 2/ED",
                        "CYBERLAW SIMPLIFIED",
                        "DATA NETWORK DESIGN 3/ED",
                        "DATA STRUCTURES & ALGORITHMS",
                        "DATA STRUCTURES & ALGORITHMS IN JAVA 3/ED",
                        "DATA WAREHOUSING 2/ED",
                        "DATA WAREHOUSING, DATA MINING & OLAP",
                        "DECISION SUPPORT & DATA WAREHOUSE SYSTEMS",
                        "DIGITAL DESIGN 4/ED",
                        "DIGITAL SIGNAL PROCESSING 2/ED",
                        "DIGITAL SIGNAL PROCESSING: SIGNALS, SYSTEMS & FILTERS",
                        "DIGITAL TELEPHONY 3/ED",
                        "DISTRIBUTED OPERATING SYSTEMS",
                        "ELECTRICAL & ELECTRONIC MEASUREMENT",
                        "ELECTROMAGNETICS WITH APPLICATIONS 5/ED",
                        "ELEMENTS OF THE THOERY OF COMPUTATION 2/ED",
                        "ELEMENTS OF WORKSHOP TECHNOLOGY VOL-I, MANUFACTURING PROCESS 15/ED",
                        "ELEMENTS OF WORKSHOP TECHNOLOGY VOL-II, MACHINE TOOLS",
                        "ENGINEERING DRAWING & GRAPHICS USING AUTOCAD 3/ED",
                        "ENVIRONMENTAL STUDIES",
                        "ESSENTIALS OF MANAGEMENT 9/ED",
                        "FIBER-OPTIC COMMUNICATION SYSTEMS",
                        "FLEXIBLE WEB DESIGN",
                        "FLUID MECHANICS 9/ED",
                        "FUNDAMENTAL REAL ANALYSIS 4/ED",
                        "FUNDAMENTALS OF DIGITAL LOGIC WITH VERILOG DESIGN 2/ED",
                        "GAME PROGRAMMING",
                        "HB OF ANALYTICAL INSTRUMENTATION 2/ED",
                        "HEALTH EDUCATION",
                        "INFORMATION THOERY CODING & CRYPTOGRAPHY 2/ED",
                        "INTRODUCTION TO AI ROBOTICS",
                        "INTRODUCTION TO DATA COMMUNICATIONS & NETWORKING",
                        "INTRODUCTION TO LINEAR ALGEBRA WITH APPLICATION",
                        "INTRODUCTION TO MICROPROCESSORS 3/ED",
                        "JAVA FUNDAMENTALS",
                        "KNOWLEDGE MANAGEMENT",
                        "LINEAR INTEGRATED CIRCUITS",
                        "LOCAL AREA NETWORKS 2/ED",
                        "MAKE WINNING A HABIT",
                        "MENTAL ABILITY & QUANTITATIVE APTITUDE 5/ED",
                        "MENTAL ABILITY AND QUANTITATIVE APTITUDE FOR COMPETITIVE EXAM 3/ED",
                        "MICROPROCESSOR 8086 : ARCH, PROG & INTERFACING",
                        "MICROPROCESSOR, ARCHITECTURE PROGRAMMING & APPL WITH THE 8085 5/ED",
                        "MICROPROCESSORS & INTERFACING 3/ED",
                        "MICROPROCESSORS & MICROCONTROLLERS",
                        "MICROWAVE ENGINEERING",
                        "NETWORK MANAGEMENT: PRINCIPLES & PRACTICE 2/ED",
                        "NETWORKS, LINES & FIELDS 2/ED",
                        "NEURAL NETWORKS 2/ED",
                        "POWER ELECTRONICS 2/ED",
                        "PRINCIPLES OF ELECTRONICS INSTRUMENTATION",
                        "PROBABILITY & QUEUEING THOERY",
                        "PROBABILITY & STATISTICS 8/ED",
                        "PROBABILITY & RANDOM PROCESSES",
                        "PROCESS CONTROL INSTRUMENTATION TECHNOLOGY 3/ED",
                        "PROGRAMMING LANGUAGES CONCEPTS & CONST 2/ED",
                        "PROJECT MANAGEMENT FOR ENGINEERING, BUSINESS & TECHNOLOGY 4/ED",
                        "REAL-TIME SYSTEMS",
                        "SATELLITE COMMUNICATION",
                        "SIGNALS & SYSTEMS 4/ED",
                        "SIMULATION MODELLING AND ANALYSIS 4/ED",
                        "SOFTWARE ENGINEERING 2/ED",
                        "SOLID STATE ELECTRONIC DEVICES 6/ED",
                        "STOICHIOMETRY 5/ED",
                        "THE DESIGN & ANALYSIS OF COMPUTER ALGORITHMS",
                        "THE ENGLISH LANGUAGE",
                        "THE UNIFIED MODELING LANGUAGE USER GUIDE",
                        "TROUBLE SHOOTING: ELECTRONIC EQUIPMENT 2/ED"
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
                TabComputerFragment.this.adapter.getFilter().filter(cs);
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

            Intent i = new Intent(getActivity().getBaseContext(), BookDisplayCompsActivity.class);
            i.putExtra("idbycomps", pos);
            startActivity(i);
        }
    };




}
