package com.example.aheat.sidebar.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aheat on 6/10/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "wasiat.db";
    private static final int dbVersion = 1;


    public DBHelper(Context context){
        super(context, dbName, null, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE IF NOT EXISTS tableWasiat (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "judul TEXT, isi TEXT );";
        Log.d("Data", "onCreate: "+query);
        db.execSQL(query);
        query = "INSERT INTO tablewasiat VALUES " +
                "('1', 'Karena Setia Menjunjung Perintah', ' Karena Setia Menjunjung Perintah, Menghidupkan Quran menghidupkan Sunnah," +
                " Banyak terhulur butiran hikmah, Falhamdullah wasysyukurkah')," +
                "('2', 'Setelah Berazam Ke Rumah Sendiri', 'Setelah Berazam Ke Rumah Sendiri, Rumah Haqiqi bukan majazi," +
                "Banyak bantuan Ilahi Rabbi, Ke Khdam Selaparang Rinjani')," +
                "('3', 'Datu Bersama Ayahandanya', ' Datu Bersama Ayahandanya, Limpahkan takluk dan kumbakarna," +
                " Sapu jagat dan sebagainya, Bukti rinjani dan Gadjah Mada')," +
                "('4', 'Guci sengenger berlambang rapi', ' Guci sengenger berlambang rapi, Naga dan ayam sapi kelinci," +
                " Hikmat berlongas sangat berarti, Tunjukkan tanda kebesaran Ilahi')," +
                "('5' , 'Kelinci lari kebawah beringin', ' Kelinci lari kebawah beringin, Ditertawai kelinci sepenuh angin," +
                " Ayam berkokok naga dipimpin, Obat mujarab hikmat Ilahi')," +
                "('6', 'Mustika insane hikmatnya tinggi', ' Mustika insane hikmatnya tinggi, Dan alat tabligh lampu dan guci," +
                " Qarurah hikmat memproduksi, Obat mujarat hikmat Ilahi')," +
                "('7', 'Pusaka Rabi’ah bernama “bayu”', ' Pusaka Rabi’ah bernama “bayu”, Dipusakakan pada yang maju," +
                " Aktif berjuang siap selalu, Tahan uji seribu satu')," +
                "('8', 'Pusaka Pejanggik mudah tibanya', ' Pusaka Pejanggik mudah tibanya, Tidak disangka sultan wasithnya," +
                " Ghaib Al-Jazair bertanda mata, Dan Kali Musa pun beri tanda')," +
                "('9', 'Sayid Abdullah shahib ayahanda', ' Sayid Abdullah shahib ayahanda, Di perang Bali Congah-Peraya," +
                " Limpahkan pula batu berguna, Sambil memberi nasihat cinta')," +
                "('10', 'DEWI mengirim sebuah kelapa', ' DEWI mengirim sebuah kelapa, Tinggi pohonnya lima ribu depa," +
                " Batu keliling tugasnya menjaga, Pulau Lombok selama-lamanya')," +
                "('11', 'Dapat dipinjam sehari semalam', ' Dapat dipinjam sehari semalam, Setelah itu kembali menyelam," +
                " Berkeliling terus siang dan malam, Semoga barakat tetap tergenggam')," +
                "('12', 'Pohon kelapa di alam hikmah', ' Pohon kelapa di alam hikmah, Tidak berada di kebun dan sawah" +
                " Dipetik oleh petugas hadlrah, Syaid Khalidi pemberi isyarah')," +
                "('13', 'Sangat ajaibnya pengambilan batu', ' Sangat ajaibnya pengambilan batu, Ia berpindah kesana kesitu," +
                " Ngembalikannya secara tertentu, Diterimakan di atas perahu')," +
                "('14', 'Di Sasak ini banyaklah masih', ' Di Sasak ini banyaklah masih, Pusaka lama ditempat tersisih," +
                " Lobar Loteng ditempat tersisih, Di Lotim penuh dijaga patih')," +
                "('15', 'Hamba yang khusus sering bertemu', ' Hamba yang khusus sering bertemu, Di tempat yang memang sudah tertentu" +
                " Karena mereka mendapat restu, Dengan mudahnya membuka pintu')," +
                "('16', 'Maulana Malik banyak berjasa', ' Maulana Malik banyak berjasa, Meberi bantuan hiburan nyata," +
                " Terima kasih berjuta-juta, Wasysyukurulahu Abadan abada')," +
                "('17', 'Makhluk jinak aktif beraksi', ' Makhluk jinak aktif beraksi, Ke Kalimantan dan Sulawesi," +
                " Ke NTT Sumatera dan Bali, Bahkan ke Sabang sampai Meraoke')," +
                "('18', 'Malahan sampai keluar negeri', ' Malahan sampai keluar negeri, Seperti Makkah Mesir Magrabi," +
                " Amerika Rusia Jepang Itali, Dengan hikmat Ilahi Rabbi')," +
                "('19', 'Pandai memakai seluruh bahasa', ' Pandai memakai seluruh bahasa, Yang nyata berlaku dalam dunia," +
                " Ia tak perlu berhadapan muka, Cukup hanya ke arah mereka')," +
                "('20', 'Sering memakai seribu satu', ' Sering memakai seribu satu, Wajahnya terang di sana di situ," +
                " Mengajak Ummat kejalan yang satu, Hikmah Ilahi pelimpah restu')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS tableWasiat");
        onCreate(db);
    }

    public List<DatabaseModel> getDataFromDB(){

        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        String query = "SELECT * FROM tablewasiat";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                DatabaseModel model = new DatabaseModel();
                model.setJudul(cursor.getString(1));
                model.setIsi(cursor.getString(2));
                modelList.add(model);
            }while (cursor.moveToNext());
        }

        Log.d("Data", modelList.toString());

        return modelList;

    }

}
