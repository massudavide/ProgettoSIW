package it.uniroma3.siw.progettoSIW;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.progettoSIW.model.Admin;
import it.uniroma3.siw.progettoSIW.model.Album;
import it.uniroma3.siw.progettoSIW.model.Foto;
import it.uniroma3.siw.progettoSIW.model.Fotografo;
import it.uniroma3.siw.progettoSIW.model.Richiesta;
import it.uniroma3.siw.progettoSIW.repository.*;



@Component
public class DBpopulation implements ApplicationRunner{

	@Autowired
	private FotoRepository fotoRepository;

	@Autowired
	private AlbumRepository albumRepository;


	@Autowired
	private FotografoRepository fotografoRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RichiestaRepository richiestaRepository;

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
		String u11 = "https://www.spettakolo.it/wp-content/uploads/2016/08/3eaecbb9475146f691e18c9b533e950f.jpg";
		String u12 = "https://cdn.allwallpaper.in/wallpapers/1920x1440/8754/music-concert-1920x1440-wallpaper.jpg";
		String u13 = "https://wallpapercave.com/wp/wp2157814.jpg";
		String u14 = "http://img.fliptab.io/michael_jordan/1920x1200/michael_jordan-21.jpg";
		String u15 = "https://images.alphacoders.com/611/thumb-1920-611772.jpg";
		String u16 = "https://static.ohga.it/wp-content/uploads/sites/24/2018/12/aurora-boreale.jpg";


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
		Album a7 = new Album("Musica",fg1);

		fg2.getAlbum().add(a1);
		fg2.getAlbum().add(a2);
		fg3.getAlbum().add(a3);
		fg3.getAlbum().add(a4);
		fg1.getAlbum().add(a5);
		fg3.getAlbum().add(a6);
		fg1.getAlbum().add(a7);


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
		Foto f11 = new Foto("GunsnRoses", a7 , u11);
		Foto f12 = new Foto("Il concerto", a7 , u12);
		Foto f13 = new Foto("Linkin Park", a7 , u13);
		Foto f14 = new Foto("Jordan", a1 , u14);
		Foto f15 = new Foto("La grande sfida", a1 , u15);
		Foto f16 = new Foto("Aurora boreale", a2 , u16);

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
		a7.getFoto().add(f11);
		a7.getFoto().add(f12);
		a7.getFoto().add(f13);
		a1.getFoto().add(f14);
		a1.getFoto().add(f15);
		a2.getFoto().add(f16);




		this.albumRepository.save(a1);
		this.albumRepository.save(a2);
		this.albumRepository.save(a3);
		this.albumRepository.save(a4);
		this.albumRepository.save(a5);
		this.albumRepository.save(a6);
		this.albumRepository.save(a7);




		this.fotoRepository.save(f7);
		this.fotoRepository.save(f12);
		this.fotoRepository.save(f16);
		this.fotoRepository.save(f14);
		this.fotoRepository.save(f15);
		this.fotoRepository.save(f13);
		this.fotoRepository.save(f11);
		this.fotoRepository.save(f8);
		this.fotoRepository.save(f9);
		this.fotoRepository.save(f10);
		this.fotoRepository.save(f1);
		this.fotoRepository.save(f2);
		this.fotoRepository.save(f3);
		this.fotoRepository.save(f4);
		this.fotoRepository.save(f5);
		this.fotoRepository.save(f6);



		Admin admin= new Admin("admin", "admin");
		this.adminRepository.save(admin);


		Richiesta r1= new Richiesta();
		List<Foto> lista1= new ArrayList<Foto>();
		lista1.add(f4);
		lista1.add(f2);
		r1.setListaFoto(lista1);
		r1.setEmail("marselo12@hotmail.it");

		Richiesta r2= new Richiesta();
		List<Foto> lista2= new ArrayList<Foto>();
		lista2.add(f9);
		r2.setListaFoto(lista2);
		r2.setEmail("fabio92@gmail.com");

		richiestaRepository.save(r1);
		richiestaRepository.save(r2);



	}


}