package com.turkerkizilcik.ykskocum;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Locale;


public class NameFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButtonSay, radioButtonSoz, radioButtonEA, radioButtonDil, radioButton;
    Button button;
    SharedPreferences sharedPreferences;
    EditText personName;

    private FirebaseAuth mAuth;

    TextView textView;
    ArrayList<String> arrayList;
    Dialog dialog;

    TextView textViewBolum;
    ArrayList<String> arrayListBolum;
    Dialog dialogBolum;


    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public NameFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    public void upload (View view) {


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioButtonSay = view.findViewById(R.id.radioButtonSayisal);
        radioButtonSoz = view.findViewById(R.id.radioButtonSozel);
        radioButtonEA = view.findViewById(R.id.radioButtonEA);
        radioButtonDil = view.findViewById(R.id.radioButtonDil);
        button = view.findViewById(R.id.buttonSaver);
        personName = view.findViewById(R.id.editTextPersonName);
        radioGroup = view.findViewById(R.id.radioGroup);
        sharedPreferences = this.getActivity().getSharedPreferences("com.turkerkizilcik.ykskocum", Context.MODE_PRIVATE);

        textView = view.findViewById(R.id.text_view);
        textViewBolum = view.findViewById(R.id.text_view_bolum);

        //database = FirebaseDatabase.getInstance();
        //databaseReference = database.getReference("https://ykskocum-7ba62-default-rtdb.firebaseio.com");
        //databaseReference.child("").setValue("daşşağım");


        database = FirebaseDatabase.getInstance("https://ykskocum-7ba62-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference("Profiller");


        arrayList = new ArrayList<>();
        arrayList.add("-----DEVLET ÜNİVERSİTELERİ-----");
        arrayList.add("ABDULLAH GÜL ÜNİVERSİTESİ                                   ");
        arrayList.add("ADANA ALPARSLAN TÜRKEŞ BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ      ");
        arrayList.add("ADIYAMAN ÜNİVERSİTESİ                                       ");
        arrayList.add("AFYON KOCATEPE ÜNİVERSİTESİ                                 ");
        arrayList.add("AFYONKARAHİSAR SAĞLIK BİLİMLERİ ÜNİVERSİTESİ                ");
        arrayList.add("AĞRI İBRAHİM ÇEÇEN ÜNİVERSİTESİ                             ");
        arrayList.add("AKDENİZ ÜNİVERSİTESİ                                        ");
        arrayList.add("AKSARAY ÜNİVERSİTESİ                                        ");
        arrayList.add("ALANYA ALAADDİN KEYKUBAT ÜNİVERSİTESİ                       ");
        arrayList.add("AMASYA ÜNİVERSİTESİ                                         ");
        arrayList.add("ANADOLU ÜNİVERSİTESİ                                        ");
        arrayList.add("ANKARA HACI BAYRAM VELİ ÜNİVERSİTESİ                        ");
        arrayList.add("ANKARA SOSYAL BİLİMLER ÜNİVERSİTESİ                         ");
        arrayList.add("ANKARA ÜNİVERSİTESİ                                         ");
        arrayList.add("ANKARA YILDIRIM BEYAZIT ÜNİVERSİTESİ                        ");
        arrayList.add("ARDAHAN ÜNİVERSİTESİ                                        ");
        arrayList.add("ARTVİN ÇORUH ÜNİVERSİTESİ                                   ");
        arrayList.add("ATATÜRK ÜNİVERSİTESİ                                        ");
        arrayList.add("AYDIN ADNAN MENDERES ÜNİVERSİTESİ                           ");
        arrayList.add("BALIKESİR ÜNİVERSİTESİ                                      ");
        arrayList.add("BANDIRMA ONYEDİ EYLÜL ÜNİVERSİTESİ                          ");
        arrayList.add("BARTIN ÜNİVERSİTESİ                                         ");
        arrayList.add("BATMAN ÜNİVERSİTESİ                                         ");
        arrayList.add("BAYBURT ÜNİVERSİTESİ                                        ");
        arrayList.add("BİLECİK ŞEYH EDEBALİ ÜNİVERSİTESİ                           ");
        arrayList.add("BİNGÖL ÜNİVERSİTESİ                                         ");
        arrayList.add("BİTLİS EREN ÜNİVERSİTESİ                                    ");
        arrayList.add("BOĞAZİÇİ ÜNİVERSİTESİ                                       ");
        arrayList.add("BOLU ABANT İZZET BAYSAL ÜNİVERSİTESİ                        ");
        arrayList.add("BURDUR MEHMET AKİF ERSOY ÜNİVERSİTESİ                       ");
        arrayList.add("BURSA TEKNİK ÜNİVERSİTESİ                                   ");
        arrayList.add("BURSA ULUDAĞ ÜNİVERSİTESİ                                   ");
        arrayList.add("ÇANAKKALE ONSEKİZ MART ÜNİVERSİTESİ                         ");
        arrayList.add("ÇANKIRI KARATEKİN ÜNİVERSİTESİ                              ");
        arrayList.add("ÇUKUROVA ÜNİVERSİTESİ                                       ");
        arrayList.add("DİCLE ÜNİVERSİTESİ                                          ");
        arrayList.add("DOKUZ EYLÜL ÜNİVERSİTESİ                                    ");
        arrayList.add("DÜZCE ÜNİVERSİTESİ                                          ");
        arrayList.add("EGE ÜNİVERSİTESİ                                            ");
        arrayList.add("ERCİYES ÜNİVERSİTESİ                                        ");
        arrayList.add("ERZİNCAN BİNALİ YILDIRIM ÜNİVERSİTESİ                       ");
        arrayList.add("ERZURUM TEKNİK ÜNİVERSİTESİ                                 ");
        arrayList.add("ESKİŞEHİR OSMANGAZİ ÜNİVERSİTESİ                            ");
        arrayList.add("ESKİŞEHİR TEKNİK ÜNİVERSİTESİ                               ");
        arrayList.add("FIRAT ÜNİVERSİTESİ                                          ");
        arrayList.add("GALATASARAY ÜNİVERSİTESİ                                    ");
        arrayList.add("GAZİ ÜNİVERSİTESİ                                           ");
        arrayList.add("GAZİANTEP İSLAM BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ             ");
        arrayList.add("GAZİANTEP ÜNİVERSİTESİ                                      ");
        arrayList.add("GEBZE TEKNİK ÜNİVERSİTESİ                                   ");
        arrayList.add("GİRESUN ÜNİVERSİTESİ                                        ");
        arrayList.add("GÜMÜŞHANE ÜNİVERSİTESİ                                      ");
        arrayList.add("HACETTEPE ÜNİVERSİTESİ                                      ");
        arrayList.add("HAKKARİ ÜNİVERSİTESİ                                        ");
        arrayList.add("HARRAN ÜNİVERSİTESİ                                         ");
        arrayList.add("HATAY MUSTAFA KEMAL ÜNİVERSİTESİ                            ");
        arrayList.add("HİTİT ÜNİVERSİTESİ                                          ");
        arrayList.add("IĞDIR ÜNİVERSİTESİ                                          ");
        arrayList.add("ISPARTA UYGULAMALI BİLİMLER ÜNİVERSİTESİ                    ");
        arrayList.add("İNÖNÜ ÜNİVERSİTESİ                                          ");
        arrayList.add("İSKENDERUN TEKNİK ÜNİVERSİTESİ                              ");
        arrayList.add("İSTANBUL MEDENİYET ÜNİVERSİTESİ                             ");
        arrayList.add("İSTANBUL TEKNİK ÜNİVERSİTESİ                                ");
        arrayList.add("İSTANBUL ÜNİVERSİTESİ                                       ");
        arrayList.add("İSTANBUL ÜNİVERSİTESİ-CERRAHPAŞA                            ");
        arrayList.add("İZMİR BAKIRÇAY ÜNİVERSİTESİ                                 ");
        arrayList.add("İZMİR DEMOKRASİ ÜNİVERSİTESİ                                ");
        arrayList.add("İZMİR KATİP ÇELEBİ ÜNİVERSİTESİ                             ");
        arrayList.add("İZMİR YÜKSEK TEKNOLOJİ ENSTİTÜSÜ                            ");
        arrayList.add("KAFKAS ÜNİVERSİTESİ                                         ");
        arrayList.add("KAHRAMANMARAŞ İSTİKLAL ÜNİVERSİTESİ                         ");
        arrayList.add("KAHRAMANMARAŞ SÜTÇÜ İMAM ÜNİVERSİTESİ                       ");
        arrayList.add("KARABÜK ÜNİVERSİTESİ                                        ");
        arrayList.add("KARADENİZ TEKNİK ÜNİVERSİTESİ                               ");
        arrayList.add("KARAMANOĞLU MEHMETBEY ÜNİVERSİTESİ                          ");
        arrayList.add("KASTAMONU ÜNİVERSİTESİ                                      ");
        arrayList.add("KAYSERİ ÜNİVERSİTESİ                                        ");
        arrayList.add("KIRIKKALE ÜNİVERSİTESİ                                      ");
        arrayList.add("KIRKLARELİ ÜNİVERSİTESİ                                     ");
        arrayList.add("KIRŞEHİR AHİ EVRAN ÜNİVERSİTESİ                             ");
        arrayList.add("KİLİS 7 ARALIK ÜNİVERSİTESİ                                 ");
        arrayList.add("KOCAELİ ÜNİVERSİTESİ                                        ");
        arrayList.add("KONYA TEKNİK ÜNİVERSİTESİ                                   ");
        arrayList.add("KÜTAHYA DUMLUPINAR ÜNİVERSİTESİ                             ");
        arrayList.add("KÜTAHYA SAĞLIK BİLİMLERİ ÜNİVERSİTESİ                       ");
        arrayList.add("MALATYA TURGUT ÖZAL ÜNİVERSİTESİ                            ");
        arrayList.add("MANİSA CELÂL BAYAR ÜNİVERSİTESİ                             ");
        arrayList.add("MARDİN ARTUKLU ÜNİVERSİTESİ                                 ");
        arrayList.add("MARMARA ÜNİVERSİTESİ                                        ");
        arrayList.add("MERSİN ÜNİVERSİTESİ                                         ");
        arrayList.add("MİMAR SİNAN GÜZEL SANATLAR ÜNİVERSİTESİ                     ");
        arrayList.add("MUĞLA SITKI KOÇMAN ÜNİVERSİTESİ                             ");
        arrayList.add("MUNZUR ÜNİVERSİTESİ                                         ");
        arrayList.add("MUŞ ALPARSLAN ÜNİVERSİTESİ                                  ");
        arrayList.add("NECMETTİN ERBAKAN ÜNİVERSİTESİ                              ");
        arrayList.add("NEVŞEHİR HACI BEKTAŞ VELİ ÜNİVERSİTESİ                      ");
        arrayList.add("NİĞDE ÖMER HALİSDEMİR ÜNİVERSİTESİ                          ");
        arrayList.add("ONDOKUZ MAYIS ÜNİVERSİTESİ                                  ");
        arrayList.add("ORDU ÜNİVERSİTESİ                                           ");
        arrayList.add("ORTA DOĞU TEKNİK ÜNİVERSİTESİ                               ");
        arrayList.add("OSMANİYE KORKUT ATA ÜNİVERSİTESİ                            ");
        arrayList.add("PAMUKKALE ÜNİVERSİTESİ                                      ");
        arrayList.add("RECEP TAYYİP ERDOĞAN ÜNİVERSİTESİ                           ");
        arrayList.add("SAĞLIK BİLİMLERİ ÜNİVERSİTESİ                               ");
        arrayList.add("SAKARYA UYGULAMALI BİLİMLER ÜNİVERSİTESİ                    ");
        arrayList.add("SAKARYA ÜNİVERSİTESİ                                        ");
        arrayList.add("SAMSUN ÜNİVERSİTESİ                                         ");
        arrayList.add("SELÇUK ÜNİVERSİTESİ                                         ");
        arrayList.add("SİİRT ÜNİVERSİTESİ                                          ");
        arrayList.add("SİNOP ÜNİVERSİTESİ                                          ");
        arrayList.add("SİVAS BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ                       ");
        arrayList.add("SİVAS CUMHURİYET ÜNİVERSİTESİ                               ");
        arrayList.add("SÜLEYMAN DEMİREL ÜNİVERSİTESİ                               ");
        arrayList.add("ŞIRNAK ÜNİVERSİTESİ                                         ");
        arrayList.add("TARSUS ÜNİVERSİTESİ                                         ");
        arrayList.add("TEKİRDAĞ NAMIK KEMAL ÜNİVERSİTESİ                           ");
        arrayList.add("TOKAT GAZİOSMANPAŞA ÜNİVERSİTESİ                            ");
        arrayList.add("TRABZON ÜNİVERSİTESİ                                        ");
        arrayList.add("TRAKYA ÜNİVERSİTESİ                                         ");
        arrayList.add("TÜRK-ALMAN ÜNİVERSİTESİ                                     ");
        arrayList.add("UŞAK ÜNİVERSİTESİ                                           ");
        arrayList.add("VAN YÜZÜNCÜ YIL ÜNİVERSİTESİ                                ");
        arrayList.add("YALOVA ÜNİVERSİTESİ                                         ");
        arrayList.add("YILDIZ TEKNİK ÜNİVERSİTESİ                                  ");
        arrayList.add("YOZGAT BOZOK ÜNİVERSİTESİ                                   ");
        arrayList.add("ZONGULDAK BÜLENT ECEVİT ÜNİVERSİTESİ                        ");
        arrayList.add("-----VAKIF ÜNİVERSİTELERİ-----");
        arrayList.add("ACIBADEM MEHMET ALİ AYDINLAR ÜNİVERSİTESİ                    ");
        arrayList.add("ALANYA HAMDULLAH EMİN PAŞA ÜNİVERSİTESİ                      ");
        arrayList.add("ALTINBAŞ ÜNİVERSİTESİ                                        ");
        arrayList.add("ANKARA BİLİM ÜNİVERSİTESİ                                    ");
        arrayList.add("ANKARA MEDİPOL ÜNİVERSİTESİ                                  ");
        arrayList.add("ANTALYA AKEV ÜNİVERSİTESİ                                    ");
        arrayList.add("ANTALYA BİLİM ÜNİVERSİTESİ                                   ");
        arrayList.add("ATILIM ÜNİVERSİTESİ                                          ");
        arrayList.add("AVRASYA ÜNİVERSİTESİ                                         ");
        arrayList.add("BAHÇEŞEHİR ÜNİVERSİTESİ                                      ");
        arrayList.add("BAŞKENT ÜNİVERSİTESİ                                         ");
        arrayList.add("BEYKENT ÜNİVERSİTESİ                                         ");
        arrayList.add("BEYKOZ ÜNİVERSİTESİ                                          ");
        arrayList.add("BEZM-İ ÂLEM VAKIF ÜNİVERSİTESİ                               ");
        arrayList.add("BİRUNİ ÜNİVERSİTESİ                                          ");
        arrayList.add("ÇAĞ ÜNİVERSİTESİ                                             ");
        arrayList.add("ÇANKAYA ÜNİVERSİTESİ                                         ");
        arrayList.add("DEMİROĞLU BİLİM ÜNİVERSİTESİ                                 ");
        arrayList.add("DOĞUŞ ÜNİVERSİTESİ                                           ");
        arrayList.add("FATİH SULTAN MEHMET VAKIF ÜNİVERSİTESİ                       ");
        arrayList.add("FENERBAHÇE ÜNİVERSİTESİ                                      ");
        arrayList.add("HALİÇ ÜNİVERSİTESİ                                           ");
        arrayList.add("HASAN KALYONCU ÜNİVERSİTESİ                                  ");
        arrayList.add("IŞIK ÜNİVERSİTESİ                                            ");
        arrayList.add("İBN HALDUN ÜNİVERSİTESİ                                      ");
        arrayList.add("İHSAN DOĞRAMACI BİLKENT ÜNİVERSİTESİ                         ");
        arrayList.add("İSTANBUL 29 MAYIS ÜNİVERSİTESİ                               ");
        arrayList.add("İSTANBUL AREL ÜNİVERSİTESİ                                   ");
        arrayList.add("İSTANBUL ATLAS ÜNİVERSİTESİ                                  ");
        arrayList.add("İSTANBUL AYDIN ÜNİVERSİTESİ                                  ");
        arrayList.add("İSTANBUL BİLGİ ÜNİVERSİTESİ                                  ");
        arrayList.add("İSTANBUL ESENYURT ÜNİVERSİTESİ                               ");
        arrayList.add("İSTANBUL GALATA ÜNİVERSİTESİ                                 ");
        arrayList.add("İSTANBUL GEDİK ÜNİVERSİTESİ                                  ");
        arrayList.add("İSTANBUL GELİŞİM ÜNİVERSİTESİ                                ");
        arrayList.add("İSTANBUL KENT ÜNİVERSİTESİ                                   ");
        arrayList.add("İSTANBUL KÜLTÜR ÜNİVERSİTESİ                                 ");
        arrayList.add("İSTANBUL MEDİPOL ÜNİVERSİTESİ                                ");
        arrayList.add("İSTANBUL OKAN ÜNİVERSİTESİ                                   ");
        arrayList.add("İSTANBUL RUMELİ ÜNİVERSİTESİ                                 ");
        arrayList.add("İSTANBUL SABAHATTİN ZAİM ÜNİVERSİTESİ                        ");
        arrayList.add("İSTANBUL SAĞLIK VE TEKNOLOJİ ÜNİVERSİTESİ                    ");
        arrayList.add("İSTANBUL TİCARET ÜNİVERSİTESİ                                ");
        arrayList.add("İSTANBUL TOPKAPI ÜNİVERSİTESİ                                ");
        arrayList.add("İSTANBUL YENİ YÜZYIL ÜNİVERSİTESİ                            ");
        arrayList.add("İSTİNYE ÜNİVERSİTESİ                                         ");
        arrayList.add("İZMİR EKONOMİ ÜNİVERSİTESİ                                   ");
        arrayList.add("İZMİR TINAZTEPE ÜNİVERSİTESİ                                 ");
        arrayList.add("KADİR HAS ÜNİVERSİTESİ                                       ");
        arrayList.add("KAPADOKYA ÜNİVERSİTESİ                                       ");
        arrayList.add("KOCAELİ SAĞLIK VE TEKNOLOJİ ÜNİVERSİTESİ                     ");
        arrayList.add("KOÇ ÜNİVERSİTESİ                                             ");
        arrayList.add("KONYA GIDA VE TARIM ÜNİVERSİTESİ                             ");
        arrayList.add("KTO KARATAY ÜNİVERSİTESİ                                     ");
        arrayList.add("LOKMAN HEKİM ÜNİVERSİTESİ                                    ");
        arrayList.add("MALTEPE ÜNİVERSİTESİ                                         ");
        arrayList.add("MEF ÜNİVERSİTESİ                                             ");
        arrayList.add("MUDANYA ÜNİVERSİTESİ                                         ");
        arrayList.add("NİŞANTAŞI ÜNİVERSİTESİ                                       ");
        arrayList.add("NUH NACİ YAZGAN ÜNİVERSİTESİ                                 ");
        arrayList.add("OSTİM TEKNİK ÜNİVERSİTESİ                                    ");
        arrayList.add("ÖZYEĞİN ÜNİVERSİTESİ                                         ");
        arrayList.add("PİRİ REİS ÜNİVERSİTESİ                                       ");
        arrayList.add("SABANCI ÜNİVERSİTESİ                                         ");
        arrayList.add("SANKO ÜNİVERSİTESİ                                           ");
        arrayList.add("TED ÜNİVERSİTESİ                                             ");
        arrayList.add("TOBB EKONOMİ VE TEKNOLOJİ ÜNİVERSİTESİ                       ");
        arrayList.add("TOROS ÜNİVERSİTESİ                                           ");
        arrayList.add("TÜRK HAVA KURUMU ÜNİVERSİTESİ                                ");
        arrayList.add("UFUK ÜNİVERSİTESİ                                            ");
        arrayList.add("ÜSKÜDAR ÜNİVERSİTESİ                                         ");
        arrayList.add("YAŞAR ÜNİVERSİTESİ                                           ");
        arrayList.add("YEDİTEPE ÜNİVERSİTESİ                                        ");
        arrayList.add("YÜKSEK İHTİSAS ÜNİVERSİTESİ                                  ");
        arrayList.add("-----KKTC ÜNİVERSİTELERİ-----");
        arrayList.add("ADA KENT ÜNİVERSİTESİ                           ");
        arrayList.add("AKDENİZ KARPAZ ÜNİVERSİTESİ                     ");
        arrayList.add("ARKIN YARATICI SANATLAR VE TASARIM ÜNİVERSİTESİ ");
        arrayList.add("BAHÇEŞEHİR KIBRIS ÜNİVERSİTESİ                  ");
        arrayList.add("DOĞU AKDENİZ ÜNİVERSİTESİ                       ");
        arrayList.add("GİRNE AMERİKAN ÜNİVERSİTESİ                     ");
        arrayList.add("GİRNE ÜNİVERSİTESİ                              ");
        arrayList.add("KIBRIS AMERİKAN ÜNİVERSİTESİ                    ");
        arrayList.add("KIBRIS BATI ÜNİVERSİTESİ                        ");
        arrayList.add("KIBRIS İLİM ÜNİVERSİTESİ                        ");
        arrayList.add("KIBRIS SAĞLIK VE TOPLUM BİLİMLERİ ÜNİVERSİTESİ  ");
        arrayList.add("LEFKE AVRUPA ÜNİVERSİTESİ                       ");
        arrayList.add("RAUF DENKTAŞ ÜNİVERSİTESİ                       ");
        arrayList.add("ULUSLARARASI FİNAL ÜNİVERSİTESİ                 ");
        arrayList.add("ULUSLARARASI KIBRIS ÜNİVERSİTESİ                ");
        arrayList.add("YAKIN DOĞU ÜNİVERSİTESİ                         ");
        arrayList.add("-----YURT DIŞI ÜNİVERSİTELERİ-----");
        arrayList.add("AZERBAYCAN DEVLET PEDAGOJİ ÜNİVERSİTESİ               ");
        arrayList.add("AZERBAYCAN DİLLER ÜNİVERSİTESİ                        ");
        arrayList.add("AZERBAYCAN TIP ÜNİVERSİTESİ                           ");
        arrayList.add("BAKÜ DEVLET ÜNİVERSİTESİ                              ");
        arrayList.add("HOCA AHMET YESEVİ ULUSLARARASI TÜRK-KAZAK ÜNİVERSİTESİ");
        arrayList.add("KIRGIZİSTAN-TÜRKİYE MANAS ÜNİVERSİTESİ                ");
        arrayList.add("KOMRAT DEVLET ÜNİVERSİTESİ                            ");
        arrayList.add("ULUSLARARASI BALKAN ÜNİVERSİTESİ                      ");
        arrayList.add("ULUSLARARASI SARAYBOSNA ÜNİVERSİTESİ                  ");

        arrayListBolum = new ArrayList<>();
        arrayListBolum.add("Antropoloji                                                ");
        arrayListBolum.add("Etnoloji                                                   ");
        arrayListBolum.add("Halkbilim                                                  ");
        arrayListBolum.add("Sosyal Antropoloji                                         ");
        arrayListBolum.add("Türk Halkbilimi                                            ");
        arrayListBolum.add("Arkeoloji                                                  ");
        arrayListBolum.add("Arkeoloji Ve Sanat Tarihi                                  ");
        arrayListBolum.add("Klasik Arkeoloji                                           ");
        arrayListBolum.add("Kültür Varlıklarını Koruma Ve Onarım                       ");
        arrayListBolum.add("Prehistorya                                                ");
        arrayListBolum.add("Protohistorya Ve Ön Asya Arkeolojisi                       ");
        arrayListBolum.add("Tarih Öncesi Arkeolojisi                                   ");
        arrayListBolum.add("Taşınabilir Kültür Varlıklarını Koruma Ve Onarım           ");
        arrayListBolum.add("Bankacılık                                                 ");
        arrayListBolum.add("Bankacılık Ve Finans                                       ");
        arrayListBolum.add("Bankacılık Ve Sigortacılık                                 ");
        arrayListBolum.add("Sermaye Piyasaları Ve Portföy Yönetimi                     ");
        arrayListBolum.add("Sermaye Piyasası                                           ");
        arrayListBolum.add("Sermaye Piyasası Denetim Ve Derecelendirme                 ");
        arrayListBolum.add("Sigortacılık                                               ");
        arrayListBolum.add("Sigortacılık Ve Risk Yönetimi                              ");
        arrayListBolum.add("Sigortacılık Ve Sosyal Güvenlik                            ");
        arrayListBolum.add("Beslenme Ve Diyetetik                                      ");
        arrayListBolum.add("Adli Bilişim Mühendisliği                                  ");
        arrayListBolum.add("Bilgisayar Bilimi Ve Mühendisliği                          ");
        arrayListBolum.add("Bilgisayar Mühendisliği                                    ");
        arrayListBolum.add("Bilgisayar Ve Yazılım Mühendisliği                         ");
        arrayListBolum.add("Bilişim Sistemleri Mühendisliği                            ");
        arrayListBolum.add("Yazılım Mühendisliği                                       ");
        arrayListBolum.add("Biyoloji                                                   ");
        arrayListBolum.add("Biyomühendislik                                            ");
        arrayListBolum.add("Biyoenformatik Ve Genetik                                  ");
        arrayListBolum.add("Biyomedikal Mühendisliği                                   ");
        arrayListBolum.add("Biyosistem Mühendisliği                                    ");
        arrayListBolum.add("Biyoteknoloji                                              ");
        arrayListBolum.add("Biyoteknoloji Ve Moleküler Biyoloji                        ");
        arrayListBolum.add("Genetik Ve Biyoinformatik                                  ");
        arrayListBolum.add("Genetik Ve Biyomühendislik                                 ");
        arrayListBolum.add("Moleküler Biyoloji Ve Genetik                              ");
        arrayListBolum.add("Moleküler Biyoloji, Genetik Ve Biyomühendislik             ");
        arrayListBolum.add("Tıp Mühendisliği                                           ");
        arrayListBolum.add("Coğrafya                                                   ");
        arrayListBolum.add("Çalışma Ekonomisi Ve Endüstri İlişkileri                   ");
        arrayListBolum.add("Çevre Mühendisliği                                         ");
        arrayListBolum.add("Diş Hekimliği                                              ");
        arrayListBolum.add("Eczacılık                                                  ");
        arrayListBolum.add("Ekonometri                                                 ");
        arrayListBolum.add("Finansal Ekonometri                                        ");
        arrayListBolum.add("Elektrik Mühendisliği                                      ");
        arrayListBolum.add("Elektrik Ve Elektronik Mühendisliği                        ");
        arrayListBolum.add("Elektronik Mühendisliği                                    ");
        arrayListBolum.add("Elektronik Ve Haberleşme Mühendisliği                      ");
        arrayListBolum.add("Telekomünikasyon Mühendisliği                              ");
        arrayListBolum.add("Endüstri Mühendisliği                                      ");
        arrayListBolum.add("Endüstri Sistemleri Mühendisliği                           ");
        arrayListBolum.add("Endüstri Ve Sistem Mühendisliği                            ");
        arrayListBolum.add("İşletme Mühendisliği                                       ");
        arrayListBolum.add("Sistem Mühendisliği                                        ");
        arrayListBolum.add("Endüstri Tasarımı                                          ");
        arrayListBolum.add("Endüstri Ürünleri Tasarımı                                 ");
        arrayListBolum.add("Endüstriyel Tasarım                                        ");
        arrayListBolum.add("Endüstriyel Tasarım Mühendisliği                           ");
        arrayListBolum.add("Ekonomi Politik Ve Toplum Felsefesi                        ");
        arrayListBolum.add("Felsefe                                                    ");
        arrayListBolum.add("Astronomi Ve Uzay Bilimleri                                ");
        arrayListBolum.add("Fizik                                                      ");
        arrayListBolum.add("Fizik Mühendisliği                                         ");
        arrayListBolum.add("Optik Ve Akustik Mühendisliği                              ");
        arrayListBolum.add("Uzay Bilimleri Ve Teknolojileri                            ");
        arrayListBolum.add("Ergoterapi                                                 ");
        arrayListBolum.add("Fizik Tedavi Ve Rehabilitasyon                             ");
        arrayListBolum.add("Deniz Teknolojisi Mühendisliği                             ");
        arrayListBolum.add("Deniz Ulaştırma İşletme Mühendisliği                       ");
        arrayListBolum.add("Gemi İnşa Ve Gemi Makineleri Mühendisliği                  ");
        arrayListBolum.add("Gemi İnşaatı Mühendisliği                                  ");
        arrayListBolum.add("Gemi İnşaatı Ve Gemi Makineleri Mühendisliği               ");
        arrayListBolum.add("Gemi Makineleri İşletme Mühendisliği                       ");
        arrayListBolum.add("Gemi Ve Deniz Teknolojisi Mühendisliği                     ");
        arrayListBolum.add("Gıda Mühendisliği                                          ");
        arrayListBolum.add("Aksesuar Tasarımı                                          ");
        arrayListBolum.add("Baskı Sanatları                                            ");
        arrayListBolum.add("Bileşik Sanatlar                                           ");
        arrayListBolum.add("Cam                                                        ");
        arrayListBolum.add("Canlandırma Filmi Tasarım Ve Yönetimi                      ");
        arrayListBolum.add("Çini                                                       ");
        arrayListBolum.add("Çini Tasarımı                                              ");
        arrayListBolum.add("Çizgi Film Ve Animasyon                                    ");
        arrayListBolum.add("Dramatik Yazarlık                                          ");
        arrayListBolum.add("Dramatik Yazarlık-Dramaturji                               ");
        arrayListBolum.add("Duysal (Ses) Sanatları Tasarımı                            ");
        arrayListBolum.add("El Sanatları                                               ");
        arrayListBolum.add("El Sanatları Tasarımı Ve Üretimi                           ");
        arrayListBolum.add("Eski Çini Onarımları                                       ");
        arrayListBolum.add("Film Tasarım Ve Yazarlık                                   ");
        arrayListBolum.add("Film Tasarım Ve Yönetmenliği                               ");
        arrayListBolum.add("Film Tasarımı                                              ");
        arrayListBolum.add("Fotoğraf                                                   ");
        arrayListBolum.add("Fotoğraf Ve Grafik Sanatlar                                ");
        arrayListBolum.add("Fotoğraf Ve Video                                          ");
        arrayListBolum.add("Geleneksel Türk El Sanatları                               ");
        arrayListBolum.add("Geleneksel Türk Sanatları                                  ");
        arrayListBolum.add("Görsel İletişim                                            ");
        arrayListBolum.add("Görsel İletişim Tasarımı                                   ");
        arrayListBolum.add("Görsel Sanatlar                                            ");
        arrayListBolum.add("Görsel Sanatlar Ve Görsel İletişim Tasarımı                ");
        arrayListBolum.add("Görüntü Sanatları                                          ");
        arrayListBolum.add("Grafik                                                     ");
        arrayListBolum.add("Grafik Resimleme Ve Baskı                                  ");
        arrayListBolum.add("Grafik Sanatları                                           ");
        arrayListBolum.add("Grafik Tasarım                                             ");
        arrayListBolum.add("Halı Kilim                                                 ");
        arrayListBolum.add("Halı, Kilim Ve Eski Kumaş Desenleri                        ");
        arrayListBolum.add("Hat                                                        ");
        arrayListBolum.add("Heykel                                                     ");
        arrayListBolum.add("İletişim Sanatları                                         ");
        arrayListBolum.add("İletişim Tasarımı Ve Yönetimi                              ");
        arrayListBolum.add("İletişim Ve Tasarım                                        ");
        arrayListBolum.add("Kurgu-Ses Ve Görüntü Yönetimi                              ");
        arrayListBolum.add("Kuyumculuk                                                 ");
        arrayListBolum.add("Kuyumculuk Ve Mücevher Tasarımı                            ");
        arrayListBolum.add("Medya Ve Görsel Sanatlar                                   ");
        arrayListBolum.add("Moda Giyim Tasarımı                                        ");
        arrayListBolum.add("Moda Tasarımı                                              ");
        arrayListBolum.add("Moda Ve Tekstil Tasarımı                                   ");
        arrayListBolum.add("Plastik Sanatlar                                           ");
        arrayListBolum.add("Plastik Sanatlar Ve Resim                                  ");
        arrayListBolum.add("Resim                                                      ");
        arrayListBolum.add("Resim-Baskı Sanatları                                      ");
        arrayListBolum.add("Sahne Dekorları Ve Kostümü                                 ");
        arrayListBolum.add("Sahne Tasarımı                                             ");
        arrayListBolum.add("Sahne Ve Gösteri Sanatları Yönetimi                        ");
        arrayListBolum.add("Sanat (Tasarım) Yönetimi                                   ");
        arrayListBolum.add("Sanat Eserleri Konservasyonu Ve Restorasyonu               ");
        arrayListBolum.add("Sanat Tasarımı                                             ");
        arrayListBolum.add("Sanat Ve Kültür Yönetimi                                   ");
        arrayListBolum.add("Sanat Ve Tasarım                                           ");
        arrayListBolum.add("Sanat Yönetimi                                             ");
        arrayListBolum.add("Seramik                                                    ");
        arrayListBolum.add("Seramik Sanatları                                          ");
        arrayListBolum.add("Seramik Ve Cam                                             ");
        arrayListBolum.add("Seramik Ve Cam Tasarımı                                    ");
        arrayListBolum.add("Takı Tasarımı                                              ");
        arrayListBolum.add("Takı Teknolojisi Ve Tasarımı                               ");
        arrayListBolum.add("Tekstil                                                    ");
        arrayListBolum.add("Tekstil Tasarım                                            ");
        arrayListBolum.add("Tekstil Tasarımı Ve Üretimi                                ");
        arrayListBolum.add("Tekstil Ve Deri Moda Tasarımı                              ");
        arrayListBolum.add("Tekstil Ve Moda Tasarımı                                   ");
        arrayListBolum.add("Tezhip                                                     ");
        arrayListBolum.add("Geomatik Mühendisliği                                      ");
        arrayListBolum.add("Harita Mühendisliği                                        ");
        arrayListBolum.add("Jeodezi Ve Fotogrametri Mühendisliği                       ");
        arrayListBolum.add("Ebelik                                                     ");
        arrayListBolum.add("Hemşirelik                                                 ");
        arrayListBolum.add("Hemşirelik Ve Sağlık Hizmetleri                            ");
        arrayListBolum.add("Hukuk                                                      ");
        arrayListBolum.add("İç Mimarlık                                                ");
        arrayListBolum.add("İç Mimarlık Ve Çevre Tasarımı                              ");
        arrayListBolum.add("Ekonomi                                                    ");
        arrayListBolum.add("Ekonomi Ve Finans                                          ");
        arrayListBolum.add("İktisat                                                    ");
        arrayListBolum.add("İşletme-Ekonomi                                            ");
        arrayListBolum.add("Animasyon                                                  ");
        arrayListBolum.add("Basın Ve Yayın                                             ");
        arrayListBolum.add("Gazetecilik                                                ");
        arrayListBolum.add("Halkla İlişkiler                                           ");
        arrayListBolum.add("Halkla İlişkiler Ve Reklamcılık                            ");
        arrayListBolum.add("Halkla İlişkiler Ve Tanıtım                                ");
        arrayListBolum.add("İletişim                                                   ");
        arrayListBolum.add("İletişim Bilimleri                                         ");
        arrayListBolum.add("Kültür Yönetimi                                            ");
        arrayListBolum.add("Medya Ve İletişim                                          ");
        arrayListBolum.add("Medya Ve İletişim Sistemleri                               ");
        arrayListBolum.add("Moda Ve Tekstil Tasarımı                                   ");
        arrayListBolum.add("Radyo Ve Televizyon                                        ");
        arrayListBolum.add("Radyo, Televizyon Ve Sinema                                ");
        arrayListBolum.add("Reklam Tasarımı Ve İletişimi                               ");
        arrayListBolum.add("Reklamcılık                                                ");
        arrayListBolum.add("Sinema Ve Dijital Medya                                    ");
        arrayListBolum.add("Sinema Ve Televizyon                                       ");
        arrayListBolum.add("Televizyon Haberciliği Ve Programcılığı                    ");
        arrayListBolum.add("Turizm Animasyonu                                          ");
        arrayListBolum.add("Yeni Medya                                                 ");
        arrayListBolum.add("Yeni Medya Ve Gazetecilik                                  ");
        arrayListBolum.add("İmalat Mühendisliği                                        ");
        arrayListBolum.add("Kontrol Mühendisliği                                       ");
        arrayListBolum.add("Kontrol Ve Otomasyon Mühendisliği                          ");
        arrayListBolum.add("Makine Ve İmalat Mühendisliği                              ");
        arrayListBolum.add("Mekatronik Mühendisliği                                    ");
        arrayListBolum.add("Mekatronik Sistemler Mühendisliği                          ");
        arrayListBolum.add("Üretim Sistemleri Mühendisliği                             ");
        arrayListBolum.add("İnşaat Mühendisliği                                        ");
        arrayListBolum.add("Dünya Dinleri                                              ");
        arrayListBolum.add("İlahiyat                                                   ");
        arrayListBolum.add("İslam Ve Din Bilimleri                                     ");
        arrayListBolum.add("İslami İlimler                                             ");
        arrayListBolum.add("Uluslararası İlahiyat                                      ");
        arrayListBolum.add("Yaygın Din Öğretimi Ve Uygulamaları                        ");
        arrayListBolum.add("Aktüerya                                                   ");
        arrayListBolum.add("Aktüerya Bilimleri                                         ");
        arrayListBolum.add("Aktüerya Ve Risk Yönetimi                                  ");
        arrayListBolum.add("İstatistik                                                 ");
        arrayListBolum.add("İstatistik Ve Bilgisayar Bilimleri                         ");
        arrayListBolum.add("İşletme                                                    ");
        arrayListBolum.add("Yönetim Bilimleri (İşletme Fakültesi)                      ");
        arrayListBolum.add("Yönetim Bilimleri Programları                              ");
        arrayListBolum.add("Jeofizik Mühendisliği                                      ");
        arrayListBolum.add("Hidrojeoloji Mühendisliği                                  ");
        arrayListBolum.add("Jeoloji Mühendisliği                                       ");
        arrayListBolum.add("Kentsel Tasarım Ve Peyzaj Mimarisi                         ");
        arrayListBolum.add("Peyzaj Mimarlığı                                           ");
        arrayListBolum.add("Şehir Ve Bölge Planlama                                    ");
        arrayListBolum.add("Kimya                                                      ");
        arrayListBolum.add("Biyokimya                                                  ");
        arrayListBolum.add("Kimya Mühendisliği                                         ");
        arrayListBolum.add("Kimya Mühendisliği Ve Uygulamalı Kimya                     ");
        arrayListBolum.add("Kimya Ve Süreç Mühendisliği                                ");
        arrayListBolum.add("Kimya-Biyoloji Mühendisliği                                ");
        arrayListBolum.add("Polimer Mühendisliği                                       ");
        arrayListBolum.add("Arp                                                        ");
        arrayListBolum.add("Bale                                                       ");
        arrayListBolum.add("Bale Dansçılığı                                            ");
        arrayListBolum.add("Bando Şefliği                                              ");
        arrayListBolum.add("Caz                                                        ");
        arrayListBolum.add("Çalgı                                                      ");
        arrayListBolum.add("Çalgı Eğitimi                                              ");
        arrayListBolum.add("Çalgı Yapım                                                ");
        arrayListBolum.add("Dans                                                       ");
        arrayListBolum.add("Drama Ve Oyunculuk                                         ");
        arrayListBolum.add("Fagot                                                      ");
        arrayListBolum.add("Flüt                                                       ");
        arrayListBolum.add("Geleneksel Türk Müzikleri                                  ");
        arrayListBolum.add("Genel Müzikoloji                                           ");
        arrayListBolum.add("Gitar                                                      ");
        arrayListBolum.add("Keman                                                      ");
        arrayListBolum.add("Klarnet                                                    ");
        arrayListBolum.add("Klasik Bale                                                ");
        arrayListBolum.add("Kompozisyon                                                ");
        arrayListBolum.add("Kompozisyon(Bestecilik)                                    ");
        arrayListBolum.add("Kompozisyon Ve Orkestra Şefliği                            ");
        arrayListBolum.add("Kontrabas                                                  ");
        arrayListBolum.add("Korno                                                      ");
        arrayListBolum.add("Koro                                                       ");
        arrayListBolum.add("Modern Dans                                                ");
        arrayListBolum.add("Müzik                                                      ");
        arrayListBolum.add("Müzik Bilimleri                                            ");
        arrayListBolum.add("Müzik Teknolosi                                            ");
        arrayListBolum.add("Müzik Teorisi                                              ");
        arrayListBolum.add("Müzik Toplulukları                                         ");
        arrayListBolum.add("Müzikoloji                                                 ");
        arrayListBolum.add("Nefesli Çalgılar Ve Vurmalı Çalgılar                       ");
        arrayListBolum.add("Obua                                                       ");
        arrayListBolum.add("Opera                                                      ");
        arrayListBolum.add("Opera Şarkıcılığı                                          ");
        arrayListBolum.add("Opera Ve Konser Şarkıcılığı                                ");
        arrayListBolum.add("Osmanlı Dönemi Karşılaştırmalı Müzik                       ");
        arrayListBolum.add("Oyunculuk                                                  ");
        arrayListBolum.add("Piyano                                                     ");
        arrayListBolum.add("Piyano Onarımı Yapımı                                      ");
        arrayListBolum.add("Piyano-Arp-Gitar                                           ");
        arrayListBolum.add("Popüler Müzik Şarkıcılığı                                  ");
        arrayListBolum.add("Sahne Sanatları                                            ");
        arrayListBolum.add("Ses Eğitimi                                                ");
        arrayListBolum.add("Şan                                                        ");
        arrayListBolum.add("Temel Bilimler                                             ");
        arrayListBolum.add("Teori                                                      ");
        arrayListBolum.add("Tiyatro                                                    ");
        arrayListBolum.add("Tiyatro Eleştirmenliği Ve Dramaturji                       ");
        arrayListBolum.add("Trombon                                                    ");
        arrayListBolum.add("Trompet                                                    ");
        arrayListBolum.add("Tuba                                                       ");
        arrayListBolum.add("Türk Din Musikisi                                          ");
        arrayListBolum.add("Türk Halk Müziği                                           ");
        arrayListBolum.add("Türk Halk Müziği Çalgı Eğitimi                             ");
        arrayListBolum.add("Türk Halk Müziği Ses Eğitimi                               ");
        arrayListBolum.add("Türk Halk Oyunları                                         ");
        arrayListBolum.add("Türk Musikisi                                              ");
        arrayListBolum.add("Türk Musikisi Temel Bilimler                               ");
        arrayListBolum.add("Türk Müziği                                                ");
        arrayListBolum.add("Türk Sanat Müziği                                          ");
        arrayListBolum.add("Türk Sanat Müziği Ses Eğitimi                              ");
        arrayListBolum.add("Türk Sanat Müziği Temel Bilimler                           ");
        arrayListBolum.add("Üflemeli Ve Vurmalı Çalgılar                               ");
        arrayListBolum.add("Viyola                                                     ");
        arrayListBolum.add("Viyolonsel                                                 ");
        arrayListBolum.add("Vurmalı Çalgılar                                           ");
        arrayListBolum.add("Yaylı Çalgılar                                             ");
        arrayListBolum.add("Yaylı Çalgılar Yapımı                                      ");
        arrayListBolum.add("Cevher Hazırlama Mühendisliği                              ");
        arrayListBolum.add("Maden Mühendisliği                                         ");
        arrayListBolum.add("Makine Mühendisliği                                        ");
        arrayListBolum.add("Maliye                                                     ");
        arrayListBolum.add("Malzeme Bilimi Ve Mühendisliği                             ");
        arrayListBolum.add("Malzeme Bilimi Ve Nano Mühendislik                         ");
        arrayListBolum.add("Malzeme Bilimi Ve Nanoteknoloji Mühendisliği               ");
        arrayListBolum.add("Malzeme Mühendisliği                                       ");
        arrayListBolum.add("Metalurji Ve Malzeme Mühendisliği                          ");
        arrayListBolum.add("Finans Matematiği                                          ");
        arrayListBolum.add("Matematik                                                  ");
        arrayListBolum.add("Matematik Mühendisliği                                     ");
        arrayListBolum.add("Matematik Ve Bilgisayar Bilimleri                          ");
        arrayListBolum.add("Matematik-Bilgisayar                                       ");
        arrayListBolum.add("Gemi Ve Yat Tasarımı                                       ");
        arrayListBolum.add("Mimarlık                                                   ");
        arrayListBolum.add("Odyoloji                                                   ");
        arrayListBolum.add("Otomotiv Mühendisliği                                      ");
        arrayListBolum.add("Raylı Sistemler Mühendisliği                               ");
        arrayListBolum.add("Ulaştırma Mühendisliği                                     ");
        arrayListBolum.add("Aile Ekonomisi Ve Beslenme Öğretmenliği                    ");
        arrayListBolum.add("Aile Ve Tüketici Bilimleri Öğretmenliği                    ");
        arrayListBolum.add("Almanca Öğretmenliği                                       ");
        arrayListBolum.add("Arapça Öğretmenliği                                        ");
        arrayListBolum.add("Beden Eğitimi Ve Spor Öğretmenliği                         ");
        arrayListBolum.add("Bilgisayar Öğretmenliği                                    ");
        arrayListBolum.add("Bilgisayar Sistemleri Öğretmenliği                         ");
        arrayListBolum.add("Bilgisayar Ve Kontrol Öğretmenliği                         ");
        arrayListBolum.add("Bilgisayar Ve Öğretim Teknolojileri Öğretmenliği           ");
        arrayListBolum.add("Biyoloji Öğretmenliği                                      ");
        arrayListBolum.add("Büro Yönetimi Öğretmenliği                                 ");
        arrayListBolum.add("Coğrafya Öğretmenliği                                      ");
        arrayListBolum.add("Çiçek, Örgü Ve Dokuma Öğretmenliği                         ");
        arrayListBolum.add("Çocuk Gelişimi Ve Okul Öncesi Öğretmenliği                 ");
        arrayListBolum.add("Dekoratif Sanatlar Öğretmenliği                            ");
        arrayListBolum.add("Din Kültürü Ve Ahlak Bilgisi Öğretmenliği                  ");
        arrayListBolum.add("Döküm Öğretmenliği                                         ");
        arrayListBolum.add("Elektrik Öğretmenliği                                      ");
        arrayListBolum.add("Elektronik Öğretmenliği                                    ");
        arrayListBolum.add("Elektronik Ve Bilgisayar Öğretmenliği                      ");
        arrayListBolum.add("Elektronik Ve Haberleşme Öğretmenliği                      ");
        arrayListBolum.add("Endüstriyel Teknoloji Öğretmenliği                         ");
        arrayListBolum.add("Enerji Öğretmenliği                                        ");
        arrayListBolum.add("Engellilerde Beden Eğitimi Ve Spor Öğretmenliği            ");
        arrayListBolum.add("Felsefe Grubu Öğretmenliği                                 ");
        arrayListBolum.add("Fen Bilgisi Öğretmenliği                                   ");
        arrayListBolum.add("Fizik Öğretmenliği                                         ");
        arrayListBolum.add("Fransızca Öğretmenliği                                     ");
        arrayListBolum.add("Giyim Endüstrisi Öğretmenliği                              ");
        arrayListBolum.add("Giyim Öğretmenliği                                         ");
        arrayListBolum.add("Görme Engelliler Öğretmenliği                              ");
        arrayListBolum.add("Grafik Öğretmenliği                                        ");
        arrayListBolum.add("Hazır Giyim Öğretmenliği                                   ");
        arrayListBolum.add("İlköğretim Din Kültürü Ve Ahlak Bilgisi Öğretmenliği       ");
        arrayListBolum.add("İlköğretim Matematik Öğretmenliği                          ");
        arrayListBolum.add("İngilizce Öğretmenliği                                     ");
        arrayListBolum.add("İngilizce Öğretmenliği Öğretimi                            ");
        arrayListBolum.add("İşitme Engelliler Öğretmenliği                             ");
        arrayListBolum.add("İşletme Öğretmenliği                                       ");
        arrayListBolum.add("Japonca Öğretmenliği                                       ");
        arrayListBolum.add("Kalıpçılık Öğretmenliği                                    ");
        arrayListBolum.add("Kimya Öğretmenliği                                         ");
        arrayListBolum.add("Konaklama İşletmeciliği Eğitimi                            ");
        arrayListBolum.add("Konaklama İşletmeciliği Öğretmenliği                       ");
        arrayListBolum.add("Kontrol Öğretmenliği                                       ");
        arrayListBolum.add("Kuaförlük Ve Güzellik Bilgisi Öğretmenliği                 ");
        arrayListBolum.add("Makine Resim Ve Konstrüksiyonu Öğretmenliği                ");
        arrayListBolum.add("Matbaa Öğretmenliği                                        ");
        arrayListBolum.add("Matematik Öğretmenliği                                     ");
        arrayListBolum.add("Mekatronik Öğretmenliği                                    ");
        arrayListBolum.add("Mesleki Resim Öğretmenliği                                 ");
        arrayListBolum.add("Metal Öğretmenliği                                         ");
        arrayListBolum.add("Mobilya Ve Dekorasyon Öğretmenliği                         ");
        arrayListBolum.add("Moda Tasarımı Öğretmenliği                                 ");
        arrayListBolum.add("Muhasebe Ve Finansman Öğretmenliği                         ");
        arrayListBolum.add("Müzik Öğretmenliği                                         ");
        arrayListBolum.add("Nakış Öğretmenliği                                         ");
        arrayListBolum.add("Okul Öncesi Öğretmenliği                                   ");
        arrayListBolum.add("Otomotiv Öğretmenliği                                      ");
        arrayListBolum.add("Özel Eğitim Öğretmenliği                                   ");
        arrayListBolum.add("Pazarlama Öğretmenliği                                     ");
        arrayListBolum.add("Resim-İş Eğitimi                                           ");
        arrayListBolum.add("Resim-İş Öğretmenliği                                      ");
        arrayListBolum.add("Sağlık Eğitimi                                             ");
        arrayListBolum.add("Seramik Öğretmenliği                                       ");
        arrayListBolum.add("Seyahat İşletmeciliği Ve Turizm Rehberliği Eğitimi         ");
        arrayListBolum.add("Seyahat İşletmeciliği Ve Turizm Rehberliği Öğretmenliği    ");
        arrayListBolum.add("Sınıf Öğretmenliği                                         ");
        arrayListBolum.add("Sosyal Bilgiler Öğretmenliği                               ");
        arrayListBolum.add("Talaşlı Üretim Öğretmenliği                                ");
        arrayListBolum.add("Tarih Öğretmenliği                                         ");
        arrayListBolum.add("Tasarım Ve Konstrüksiyon Öğretmenliği                      ");
        arrayListBolum.add("Tekstil Dokuma Ve Örgü Öğretmenliği                        ");
        arrayListBolum.add("Tekstil Öğretmenliği                                       ");
        arrayListBolum.add("Tekstil Terbiye Öğretmenliği                               ");
        arrayListBolum.add("Telekomünikasyon Öğretmenliği                              ");
        arrayListBolum.add("Tesisat Öğretmenliği                                       ");
        arrayListBolum.add("Türk Dili Ve Edebiyatı Öğretmenliği                        ");
        arrayListBolum.add("Türkçe Öğretmenliği                                        ");
        arrayListBolum.add("Türkçe Öğretmenliği Öğretim                                ");
        arrayListBolum.add("Üstün Zekâlılar Öğretmenliği                               ");
        arrayListBolum.add("Yapı Öğretmenliği                                          ");
        arrayListBolum.add("Yapı Ressamlığı Öğretmenliği                               ");
        arrayListBolum.add("Yapı Tasarımı Öğretmenliği                                 ");
        arrayListBolum.add("Zihin Engelliler Öğretmenliği                              ");
        arrayListBolum.add("Enerji Sistemleri Mühendisliği                             ");
        arrayListBolum.add("Nükleer Enerji Mühendisliği                                ");
        arrayListBolum.add("Petrol Ve Doğalgaz Mühendisliği                            ");
        arrayListBolum.add("Pilotaj                                                    ");
        arrayListBolum.add("Pilot Eğitimi                                              ");
        arrayListBolum.add("Psikoloji                                                  ");
        arrayListBolum.add("Çocuk Gelişimi                                             ");
        arrayListBolum.add("Çocuk Sağlığı Ve Gelişimi Rehberlik (Pdr)                  ");
        arrayListBolum.add("Rehberlik Ve Psikolojik Danışmanlık                        ");
        arrayListBolum.add("Acil Yardım Ve Afet Yönetimi                               ");
        arrayListBolum.add("Dil Ve Konuşma Terapisi                                    ");
        arrayListBolum.add("Gerontoloj                                                 ");
        arrayListBolum.add("Ortez-Protez                                               ");
        arrayListBolum.add("Perfüzyon                                                  ");
        arrayListBolum.add("Sağlık İdaresi                                             ");
        arrayListBolum.add("Sağlık Kurumları İşletmeciliği                             ");
        arrayListBolum.add("Sağlık Kurumları Yöneticiliği                              ");
        arrayListBolum.add("Sağlık Kurumları Yönetimi                                  ");
        arrayListBolum.add("Sağlık Memurluğu                                           ");
        arrayListBolum.add("Sağlık Yönetimi                                            ");
        arrayListBolum.add("Avrupa Birliği İlişkileri                                  ");
        arrayListBolum.add("Kamu Yönetimi                                              ");
        arrayListBolum.add("Küresel Siyaset Ve Uluslararası İlişkiler                  ");
        arrayListBolum.add("Küresel Ve Uluslararası İlişkiler                          ");
        arrayListBolum.add("Siyaset Bilimi                                             ");
        arrayListBolum.add("Siyaset Bilimi Ve Kamu Yönetimi                            ");
        arrayListBolum.add("Siyaset Bilimi Ve Uluslararası İlişkiler                   ");
        arrayListBolum.add("Toplumsal Ve Siyasal Bilimler                              ");
        arrayListBolum.add("Uluslararası Çalışmalar                                    ");
        arrayListBolum.add("Uluslararası İlişkiler                                     ");
        arrayListBolum.add("Uluslararası İlişkiler Ve Avrupa Birliği                   ");
        arrayListBolum.add("Uluslararası İlişkiler Ve Deniz Güvenliği                  ");
        arrayListBolum.add("Sosyal Hizmetler                                           ");
        arrayListBolum.add("İnsan Ve Toplum Bilimleri                                  ");
        arrayListBolum.add("Kültürel Çalışmalar                                        ");
        arrayListBolum.add("Sosyoloji                                                  ");
        arrayListBolum.add("Antrenörlük Eğitimi                                        ");
        arrayListBolum.add("Rekreasyon                                                 ");
        arrayListBolum.add("Rekreasyon Yönetimi                                        ");
        arrayListBolum.add("Spor Bilimleri                                             ");
        arrayListBolum.add("Spor Yöneticiliği                                          ");
        arrayListBolum.add("Balıkçılık Teknolojisi                                     ");
        arrayListBolum.add("Balıkçılık Teknolojisi Mühendisliği                        ");
        arrayListBolum.add("Su Bilimleri Ve Mühendisliği                               ");
        arrayListBolum.add("Su Ürünleri                                                ");
        arrayListBolum.add("Bilim Tarihi                                               ");
        arrayListBolum.add("Sanat Tarihi                                               ");
        arrayListBolum.add("Tarih                                                      ");
        arrayListBolum.add("Ağaç İşleri Endüstri Mühendisliği                          ");
        arrayListBolum.add("Aile Ve Tüketici Bilimleri                                 ");
        arrayListBolum.add("Basım Teknolojileri                                        ");
        arrayListBolum.add("Besin Teknolojisi                                          ");
        arrayListBolum.add("Bilgi Ve Belge Yönetimi                                    ");
        arrayListBolum.add("Bilgisayar Bilimleri                                       ");
        arrayListBolum.add("Bilgisayar Teknolojisi Ve Bilişim Sistemleri               ");
        arrayListBolum.add("Bilişim Sistemleri Ve Teknolojileri                        ");
        arrayListBolum.add("Denizcilik İşletmeleri Yönetimi                            ");
        arrayListBolum.add("Enformasyon Teknolojileri                                  ");
        arrayListBolum.add("Ev Ekonomisi                                               ");
        arrayListBolum.add("Gayrimenkul Ve Varlık Değerleme                            ");
        arrayListBolum.add("Gıda Teknolojisi                                           ");
        arrayListBolum.add("Girişimcilik                                               ");
        arrayListBolum.add("Gümrük İşletme                                             ");
        arrayListBolum.add("Hava Trafik Kontrol                                        ");
        arrayListBolum.add("Havacılık Elektrik Ve Elektroniği                          ");
        arrayListBolum.add("Havacılık İşletmeciliği                                    ");
        arrayListBolum.add("Havacılık Yönetimi                                         ");
        arrayListBolum.add("İnsan Kaynakları Yönetimi                                  ");
        arrayListBolum.add("İş Sağlığı Ve Güvenliği                                    ");
        arrayListBolum.add("İşletme Bilgi Yönetimi                                     ");
        arrayListBolum.add("İşletme Enformatiği                                        ");
        arrayListBolum.add("İşletme Yönetimi                                           ");
        arrayListBolum.add("Kütüphanecilik                                             ");
        arrayListBolum.add("Lojistik                                                   ");
        arrayListBolum.add("Lojistik Yönetimi                                          ");
        arrayListBolum.add("Muhasebe                                                   ");
        arrayListBolum.add("Muhasebe Bilgi Sistemleri                                  ");
        arrayListBolum.add("Muhasebe Ve Denetim                                        ");
        arrayListBolum.add("Muhasebe Ve Finansal Yönetim                               ");
        arrayListBolum.add("Mutfak Sanatları Ve Yönetimi                               ");
        arrayListBolum.add("Pazarlama                                                  ");
        arrayListBolum.add("Sivil Hava Ulaştırma İşletmeciliği                         ");
        arrayListBolum.add("Sivil Havacılık İşletmeciliği                              ");
        arrayListBolum.add("Tapu Kadastro                                              ");
        arrayListBolum.add("Teknoloji Ve Bilgi Yönetimi                                ");
        arrayListBolum.add("Tekstil Geliştirme Ve Pazarlama                            ");
        arrayListBolum.add("Uçak Elektrik-Elektronik                                   ");
        arrayListBolum.add("Uçak Gövde-Motor                                           ");
        arrayListBolum.add("Uçak Gövde-Motor Bakımı                                    ");
        arrayListBolum.add("Yönetim Bilimleri                                          ");
        arrayListBolum.add("Yönetim Bilişim Sistemleri                                 ");
        arrayListBolum.add("Deri Mühendisliği                                          ");
        arrayListBolum.add("Tekstil Mühendisliği                                       ");
        arrayListBolum.add("Tıp                                                        ");
        arrayListBolum.add("Gastronomi                                                 ");
        arrayListBolum.add("Gastronomi Ve Mutfak Sanatları                             ");
        arrayListBolum.add("Konaklama İşletmeciliği                                    ");
        arrayListBolum.add("Otel Yöneticiliği                                          ");
        arrayListBolum.add("Seyahat İşletmeciliği                                      ");
        arrayListBolum.add("Seyahat İşletmeciliği Ve Turizm Rehberliği                 ");
        arrayListBolum.add("Turizm İşletmeciliği                                       ");
        arrayListBolum.add("Turizm İşletmeciliği Ve Otelcilik                          ");
        arrayListBolum.add("Turizm Rehberliği                                          ");
        arrayListBolum.add("Turizm Ve Otel İşletmeciliği                               ");
        arrayListBolum.add("Turizm Ve Otelcilik                                        ");
        arrayListBolum.add("Yiyecek Ve İçecek İşletmeciliği                            ");
        arrayListBolum.add("Türk Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Havacılık Ve Uzay Mühendisliği                             ");
        arrayListBolum.add("Meteoroloji Mühendisliği                                   ");
        arrayListBolum.add("Uçak Mühendisliği                                          ");
        arrayListBolum.add("Uzay Mühendisliği                                          ");
        arrayListBolum.add("Ulaştırma Ve Lojistik                                      ");
        arrayListBolum.add("Uluslararası Finans                                        ");
        arrayListBolum.add("Uluslararası Finans Ve Bankacılık                          ");
        arrayListBolum.add("Uluslararası Girişimcilik                                  ");
        arrayListBolum.add("Uluslararası İşletme Yönetimi                              ");
        arrayListBolum.add("Uluslararası İşletmecilik                                  ");
        arrayListBolum.add("Uluslararası Lojistik                                      ");
        arrayListBolum.add("Uluslararası Lojistik Ve Taşımacılık                       ");
        arrayListBolum.add("Uluslararası Lojistik Yönetimi                             ");
        arrayListBolum.add("Uluslararası Ticaret                                       ");
        arrayListBolum.add("Uluslararası Ticaret Ve Finans                             ");
        arrayListBolum.add("Uluslararası Ticaret Ve Finansman                          ");
        arrayListBolum.add("Uluslararası Ticaret Ve İşletmecilik                       ");
        arrayListBolum.add("Uluslararası Ticaret Ve Lojistik                           ");
        arrayListBolum.add("Uluslararası Ticaret Ve Lojistik Yönetimi                  ");
        arrayListBolum.add("Uluslararası Ticaret Ve Pazarlama                          ");
        arrayListBolum.add("Uluslararası Ticaret, Lojistik Ve İşletmecilik             ");
        arrayListBolum.add("Veterinerlik                                               ");
        arrayListBolum.add("Alman Dili Ve Edebiyatı                                    ");
        arrayListBolum.add("Amerikan Kültürü Ve Edebiyatı                              ");
        arrayListBolum.add("Arap Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Arnavut Dili Ve Edebiyatı                                  ");
        arrayListBolum.add("Azerbaycan Türkçesi Ve Edebiyatı                           ");
        arrayListBolum.add("Boşnak Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("Bulgar Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("Çağdaş Türk Lehçeleri Ve Edebiyatları                      ");
        arrayListBolum.add("Çağdaş Yunan Dili Ve Edebiyatı                             ");
        arrayListBolum.add("Çerkez Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("Çeviribilim (Almanca)                                      ");
        arrayListBolum.add("Çeviribilim (İngilizce)                                    ");
        arrayListBolum.add("Çin Dili Ve Edebiyatı                                      ");
        arrayListBolum.add("Dilbilim                                                   ");
        arrayListBolum.add("Ermeni Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("Eski Yunan Dili Ve Edebiyatı                               ");
        arrayListBolum.add("Fars Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Fransız Dili Ve Edebiyatı                                  ");
        arrayListBolum.add("Gürcü Dili Ve Edebiyatı                                    ");
        arrayListBolum.add("Hırvat Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("Hindoloji                                                  ");
        arrayListBolum.add("Hititoloji                                                 ");
        arrayListBolum.add("Hungaroloji                                                ");
        arrayListBolum.add("İbrani Dili Ve Edebiyatı                                   ");
        arrayListBolum.add("İngiliz Dil Bilimi                                         ");
        arrayListBolum.add("İngiliz Dili Ve Edebiyatı                                  ");
        arrayListBolum.add("İngiliz Dili Ve Karşılaştırmalı Edebiyat                   ");
        arrayListBolum.add("İspanyol Dili Ve Edebiyatı                                 ");
        arrayListBolum.add("İtalyan Dili Ve Edebiyatı                                  ");
        arrayListBolum.add("Japon Dili Ve Edebiyatı                                    ");
        arrayListBolum.add("Karşılaştırmalı Edebiyat                                   ");
        arrayListBolum.add("Karşılaştırmalı Edebiyat (İngilizce)                       ");
        arrayListBolum.add("Kore Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Koreoloji                                                  ");
        arrayListBolum.add("Kürt Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Latin Dili Ve Edebiyatı                                    ");
        arrayListBolum.add("Leh Dili Ve Edebiyatı                                      ");
        arrayListBolum.add("Mütercim-Tercümanlık (Fransızca)                           ");
        arrayListBolum.add("Mütercim-Tercümanlık (Almanca)                             ");
        arrayListBolum.add("Mütercim-Tercümanlık (Arapça)                              ");
        arrayListBolum.add("Mütercim-Tercümanlık (Bulgarca)                            ");
        arrayListBolum.add("Mütercim-Tercümanlık (Çift Dilli: İngilizce-Almanca)       ");
        arrayListBolum.add("Mütercim-Tercümanlık (Çift Dilli: İngilizce-Fransızca)     ");
        arrayListBolum.add("Mütercim-Tercümanlık (Çince)                               ");
        arrayListBolum.add("Mütercim-Tercümanlık (Farsça)                              ");
        arrayListBolum.add("Mütercim-Tercümanlık (Fransızca)                           ");
        arrayListBolum.add("Mütercim-Tercümanlık (İngilizce)                           ");
        arrayListBolum.add("Mütercim-Tercümanlık (Rusça)                               ");
        arrayListBolum.add("Mütercim-Tercümanlık (Türkçe-İngilizce-Fransızca)          ");
        arrayListBolum.add("Mütercim-Tercümanlık (Türkçe-Almanca-İngilizce)            ");
        arrayListBolum.add("Polonya Dili Ve Kültürü (Lehçe)                            ");
        arrayListBolum.add("Rus Dili Ve Edebiyatı                                      ");
        arrayListBolum.add("Sinoloji                                                   ");
        arrayListBolum.add("Sümeroloji                                                 ");
        arrayListBolum.add("Urdu Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Yunan Dili Ve Edebiyatı                                    ");
        arrayListBolum.add("Zaza Dili Ve Edebiyatı                                     ");
        arrayListBolum.add("Bahçe Bitkileri                                            ");
        arrayListBolum.add("Bitki Koruma                                               ");
        arrayListBolum.add("Bitkisel Üretim                                            ");
        arrayListBolum.add("Bitkisel Üretim Ve Teknolojileri                           ");
        arrayListBolum.add("Hayvansal Üretim                                           ");
        arrayListBolum.add("Organik Tarım İşletmeciliği                                ");
        arrayListBolum.add("Orman Endüstrisi Mühendisliği                              ");
        arrayListBolum.add("Orman Mühendisliği                                         ");
        arrayListBolum.add("Performans                                                 ");
        arrayListBolum.add("Süt Teknolojisi                                            ");
        arrayListBolum.add("Tarım Ekonomisi                                            ");
        arrayListBolum.add("Tarım Makineleri                                           ");
        arrayListBolum.add("Tarım Teknolojisi                                          ");
        arrayListBolum.add("Tarımsal Biyoteknoloji                                     ");
        arrayListBolum.add("Tarımsal Genetik Mühendisliği                              ");
        arrayListBolum.add("Tarımsal Yapılar Ve Sulama                                 ");
        arrayListBolum.add("Tarla Bitkileri                                            ");
        arrayListBolum.add("Toprak                                                     ");
        arrayListBolum.add("Toprak Bilimi Ve Bitki Besleme                             ");
        arrayListBolum.add("Tütün Eksperliği Yüksekokulu                               ");
        arrayListBolum.add("Yaban Hayatı Ekolojisi Ve Yönetimi                         ");
        arrayListBolum.add("Zeotekni                                                   ");
        arrayListBolum.add("Ziraat Mühendisliği                                        ");
        arrayListBolum.add("Zootekni                                                   ");


        textViewBolum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBolum = new Dialog(getActivity());
                dialogBolum.setContentView(R.layout.dialog_searchable_spinner_bolum);
                dialogBolum.getWindow().setLayout(900, 1500);
                dialogBolum.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogBolum.show();

                EditText editTextBolum = dialogBolum.findViewById(R.id.edit_text_bolum);
                ListView listViewBolum = dialogBolum.findViewById(R.id.list_view_bolum);

                ArrayAdapter<String> adapterBolum = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListBolum);
                listViewBolum.setAdapter(adapterBolum);

                editTextBolum.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapterBolum.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewBolum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textViewBolum.setText(adapterBolum.getItem(i));
                        dialogBolum.dismiss();
                    }
                });

            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(900, 1500);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    int radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = view.findViewById(radioId);
                    Toast.makeText(getContext(), "Seçiminiz: " + radioButton.getText() , Toast.LENGTH_SHORT).show();
                }
        });

        view.findViewById(R.id.buttonSaver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth = FirebaseAuth.getInstance();
                String userEmail = mAuth.getCurrentUser().getUid();
                String uniIsmi = textView.getText().toString().toLowerCase();
                String capitalizedUniIsmi =  StringUtils.capitalize(uniIsmi);

                //textView.getText().toString() + "-" + textViewBolum.getText().toString().toUpperCase(Locale.ROOT) + " Bölümü"

                if(!textView.getText().toString().equals("-----DEVLET ÜNİVERSİTELERİ-----")
                        && !textView.getText().toString().equals("-----VAKIF ÜNİVERSİTELERİ-----")
                        && !textView.getText().toString().equals("-----KKTC ÜNİVERSİTELERİ-----")
                        && !textView.getText().toString().equals("-----YURT DIŞI ÜNİVERSİTELERİ-----")
                        && !textView.getText().toString().equals("")){
                    if(!personName.getText().toString().equals("")) {
                        if (radioGroup.getCheckedRadioButtonId() != -1) {
                            if (!textViewBolum.getText().toString().equals("")) {
                                    //sharedPreferences.edit().putInt("y", 1).apply();
                                databaseReference.child(userEmail).child("Name").setValue(personName.getText().toString());
                                databaseReference.child(userEmail).child("Hedef").setValue(capitalizedUniIsmi);
                                databaseReference.child(userEmail).child("Alan").setValue(radioButton.getText().toString());
                            }  else {
                                Toast.makeText(getActivity(), "Lütfen üniversite bölümünüzü seçiniz.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Lütfen alanınızı seçiniz", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Lütfen adınızı giriniz.", Toast.LENGTH_SHORT).show();
                    }
                }  else {
                    Toast.makeText(getActivity(), "Lütfen bir üniversite seçiniz.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}




