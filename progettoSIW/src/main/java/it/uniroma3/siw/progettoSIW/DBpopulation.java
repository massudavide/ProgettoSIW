package it.uniroma3.siw.progettoSIW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.progettoSIW.model.Album;
import it.uniroma3.siw.progettoSIW.model.Foto;
import it.uniroma3.siw.progettoSIW.model.Fotografo;
import it.uniroma3.siw.progettoSIW.repository.*;



@Component
public class DBpopulation implements ApplicationRunner{
	
	@Autowired
	private FotoRepository fotoRepository;

	@Autowired
	private AlbumRepository albumRepository;
	

	@Autowired
	private FotografoRepository fotografoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
	}

	
	private void addAll() {
		System.out.print("Aggiungo fotografi, album e fotografie");

		String u1 = "https://wallpaperplay.com/walls/full/3/7/7/117089.jpg";
		String u2 = "https://wallpaperstock.net/wallpapers/thumbs1/27883wide.jpg";
		String u3 = "https://i.pinimg.com/originals/d4/b9/6b/d4b96bea455c3bcefb0a6704e7b603c8.jpg";
		String u4 = "http://hdviewer.com/wp-content/uploads/2018/07/Wedding-HD-Wallpapers-40.jpg";
		String u5 = "https://images4.alphacoders.com/430/thumb-1920-43034.jpg";
		String u6 = "https://i.imgur.com/2dxaFs9.jpg";
		String u7 = "http://media-s3.blogosfere.it/styleandfashion/images/alberta%20ferretti%20FW%202012_001%20%281%29.jpg";
		String u8 = "http://famiglia-fleming.it/wp-content/uploads/2017/11/pexels-photo-236047.jpeg";
		String u9 = "https://wallpapercave.com/wp/wTEV3Wl.jpg";
		String u10 = "http://www.accomodations.asia/bigimg/56/569024_wallpaper-paesaggi.jpg";


		Fotografo fg1= new Fotografo("Marco", "Verdi");
		this.fotografoRepository.save(fg1);
		Fotografo fg2= new Fotografo("Franco", "Marini");
		this.fotografoRepository.save(fg2);
		Fotografo fg3= new Fotografo("Davide", "Massuda");
		this.fotografoRepository.save(fg3);
		
		Album a1 = new Album("Sport", fg2);
		Album a2 = new Album("Paesaggi",fg2);
		Album a3 = new Album("Matrimoni",fg3);
		Album a4 = new Album("Animali",fg3);
		Album a5 = new Album("Moda",fg1);
		Album a6 = new Album("Spazio",fg3);
		
		fg2.getAlbum().add(a1);
		fg2.getAlbum().add(a2);
		fg3.getAlbum().add(a3);
		fg3.getAlbum().add(a4);
		fg1.getAlbum().add(a5);
		fg3.getAlbum().add(a6);
		

		
		Foto f1 = new Foto("Il leone", a4 , u1);
		Foto f2 = new Foto("La corsa", a1 , u2);
		Foto f3 = new Foto("Allenamento", a1 , u3);
		Foto f4 = new Foto("Un Matrimonio", a3 , u4);
		Foto f5 = new Foto("Pianeti", a6 , u5);
		Foto f6 = new Foto("Un nuovo mondo", a6 , u6);
		Foto f7 = new Foto("Una sfilata", a5 , u7);
		Foto f8 = new Foto("Il campo toscano", a2 , u8);
		Foto f9 = new Foto("L'orso selvaggio", a4  , u9);
		Foto f10 = new Foto("Zona rocciosa", a2 , u10);
		
		a1.getFoto().add(f2);
		a1.getFoto().add(f3);
		a2.getFoto().add(f10);
		a2.getFoto().add(f8);
		a3.getFoto().add(f4);
		a4.getFoto().add(f9);
		a4.getFoto().add(f1);
		a5.getFoto().add(f7);
		a6.getFoto().add(f5);
		a6.getFoto().add(f6);
		
	
		

		this.albumRepository.save(a1);
		this.albumRepository.save(a2);
		this.albumRepository.save(a3);
		this.albumRepository.save(a4);
		this.albumRepository.save(a5);
		this.albumRepository.save(a6);




		this.fotoRepository.save(f1);
		this.fotoRepository.save(f2);
		this.fotoRepository.save(f3);
		this.fotoRepository.save(f4);
		this.fotoRepository.save(f5);
		this.fotoRepository.save(f6);
		this.fotoRepository.save(f7);
		this.fotoRepository.save(f8);
		this.fotoRepository.save(f9);
		this.fotoRepository.save(f10);
	


		
	}

	
	
}