package com.example.dendy.utsbarunemen;

public class Novel {

    private int ID;
    private String Judul;
    private String Penulis;
    private String Penerbit;
    private String Tahunrilis;
    private String Sinopsis;
//    private int Thumbnail ;

    public Novel(){

    }

    public Novel(int id, String judul, String penulis, String penerbit, String tahunrilis, String sinopsis){
        ID = id;
        Judul = judul;
        Penulis = penulis;
        Penerbit = penerbit;
        Tahunrilis = tahunrilis;
        Sinopsis = sinopsis;
//        Thumbnail = thumbnail;
    }
    public int getID(){
        return ID;
    }

    public String getJudul(){
        return Judul;
    }

    public String getPenulis(){
        return Penulis;
    }

    public String getPenerbit(){
        return Penerbit;
    }

    public String getTahunrilis(){
        return Tahunrilis;
    }

    public String getSinopsis(){
        return Sinopsis;
    }

//    public int getThumbnail(){
//        return Thumbnail;
//    }
}
