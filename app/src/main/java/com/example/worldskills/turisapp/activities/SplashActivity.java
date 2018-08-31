package com.example.worldskills.turisapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Hotel;
import com.example.worldskills.turisapp.models.Restaurante;
import com.example.worldskills.turisapp.models.Sitio;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private Datos datos;
    private ArrayList<Sitio> sitios;
    private ArrayList<Hotel> hotel;
    private ArrayList<Restaurante> restaurante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        datos=new Datos(this);
        ingresarSitios();
        ingresarHoteles();
        ingresarRestaurantes();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),InicioActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },2000);
    }

    //incresar a la base de datos los sitios
    private void ingresarSitios() {

        try {
            sitios=new ArrayList<Sitio>(){{
                add(new Sitio("Cerro de Monserrate",getString(R.string.moncerrate_corta),"Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia",getString(R.string.moncerrate_larga),4.6056941,-74.0642803,R.drawable.s_monserrate));
                add(new Sitio("Parque Metropolitano Simon Bolivar",getString(R.string.metropolitano_corta),"Av. Calle 53 y Av. Esmeralda s/n, Bogotá, Cundinamarca",getString(R.string.metropolitano_larga),4.6482361,-74.3009552,R.drawable.s_simonbolivar));
                add(new Sitio("Plaza de Bolivar",getString(R.string.bolivar_corta),"Cra. 7 #11-10, Bogotá",getString(R.string.bolivar_larga),4.5981259,4.5981259,R.drawable.s_plazadebolivar));
                add(new Sitio("Centro Comercial Andino",getString(R.string.adino_corta),"Cra. 11 #82-71, Bogotá, Cundinamarca",getString(R.string.adino_larga),4.6667313,-74.0553429,R.drawable.s_andino));
                add(new Sitio("Centro Comercial Centro Mayor",getString(R.string.mayor_corta),"Calle 38 A #Sur No. 34D-51, Bogotá",getString(R.string.mayor_larga),4.5926585,-74.1263605,R.drawable.s_centromayor));
            }};
            datos.guardarSitios(sitios);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void ingresarHoteles() {

        try {
            hotel=new ArrayList<Hotel>(){{
                add(new Hotel ("Hotel Continental Bluedoors","Hotel sofisticado con un bar restaurante moderno y una cafetería, además de un gimnasio y un spa.",
                            "Avenida Jiménez No. 4 - 16\n" +
                                    "Candelaria - Centro Historico","Este elegante hotel con todo suites, situado a 4 minutos a pie de los objetos de oro del Museo del Oro, también se encuentra a 8 minutos a pie de las obras de arte del Museo Botero y a 11 minutos a pie de la Plaza de Bolívar, la plaza principal de la ciudad.\n" +
                        "Las luminosas y modernas suites disponen de Wi-Fi gratis, televisiones de pantalla plana y minibares, además de cocinas y salas de estar.\n" +
                        "El aparcamiento es gratuito. El desayuno se ofrece por un suplemento. Entre el resto de instalaciones que se incluyen en el hotel se encuentran una panadería cafetería, un bar restaurante moderno con terraza, un gimnasio y un spa.","4.6010598","-74.0705079",R.drawable.h_hotelcontinentals));

                add(new Hotel ("Hotel Tequendama y centro de convenciones","Hotel sofisticado con un bar restaurante moderno y una cafetería, además de un gimnasio y un spa. ",
                        "Cra. 10 #26-21, Bogotá, Cundinamarca","El Hotel Tequendama Bogotá, ubicado en pleno centro de Bogotá y a tan sólo 15 minutos del Aeropuerto Internacional El Dorado, ofrece todos los servicios de un hotel 5 estrellas.\n" +
                        "\n" +
                        "Dispone de 573 habitaciones de estilo clásico totalmente reformadas y dotadas con la última tecnología, todo lo necesario para garantizar el máximo confort de nuestros clientes.\n" +
                        "Además, el hotel ofrece wifi gratuito, restaurante, spa y 39 salones que lo convierten en la mejor opción para celebrar cualquier tipo de reunión de negocios o evento empresarial en Bogotá.",
                        "4.6128583","4.61285837",R.drawable.h_hoteltequendama));

                add(new Hotel("Bogota Marriot Hotel","Hotel moderno de habitaciones luminosas con spa, comida italiana y japonesa, y traslados al aeropuerto gratis.",
                        "Av. El Dorado #69 B-53, Bogotá, Cundinamarca","Este hotel de lujo, que se alberga en un edificio con fachada acristalada del distrito comercial de Salitre, está a 2 km del Parque Simón Bolívar y a 6 km del aeropuerto internacional de El Dorado.\n" +
                        "Las coloridas y modernas habitaciones tienen Wi-Fi gratis, televisores de pantalla plana y bases para iPod, así como minineveras, teteras y cafeteras. Las habitaciones superiores brindan acceso a un salón con refrescos de cortesía, mientras que las suites cuentan con salas de estar y, algunas, incluso con bañeras de hidromasaje. Hay servicio de habitaciones disponible las 24 horas.\n" +
                        "El establecimiento ofrece servicio de traslado al aeropuerto y aparcamiento de forma gratuita. El desayuno es de pago. Entre las instalaciones, se encuentran un restaurante italiano y uno japonés, además de un spa, una piscina cubierta y un gimnasio.",
                        "4.6591583","-74.1039294",R.drawable.h_hotelmarriot));

                add(new Hotel(" Hilton Bogota","Habitaciones y suites chics (algunas con vistas a la montaña), restaurante colombiano y piscina descubierta.",
                        "Cra. 7 #72-41, Bogotá","Este elegante hotel, ubicado en el distrito financiero y a 12 minutos a pie de la estación de metro de la calle 72, está a 1,6 km del exclusivo centro comercial Andino y a 5,8 km del centro de Bogotá.\n" +
                        "Las elegantes habitaciones y suites cuentan con camas de diseño personalizado, televisión de pantalla plana, conexión Wi-Fi (de pago) y cafetera. Las suites incluyen sala de estar independiente y algunas tienen vistas a la montaña. Las habitaciones Club y algunas suites ofrecen acceso a un salón con desayuno gratuito, aperitivos y bebidas vespertinas.\n" +
                        "El hotel dispone de un restaurante colombiano, de una cafetería moderna y de un bar de cócteles con DJ residente. También cuenta con una piscina descubierta y un gimnasio, además de instalaciones para reuniones y eventos y aparcamiento gratuito.",
                        "4.6554579","-74.055213",R.drawable.h_hotelhilton));

                add(new Hotel("Hotel NH Collection Bogota","Habitaciones y suites modernas en un hotel actual con un restaurante internacional, un piano bar y un spa.",
                        "Cl. 114 #6-2, Bogotá, Cundinamarca","Este moderno hotel de lujo se encuentra a 3 minutos a pie de una parada de autobús, a 2 km de las tiendas y los clubes del parque de la 93 y a 8 km del parque de atracciones Salitre Mágico.\n" +
                        "Las habitaciones están insonorizadas y son elegantes. Están equipadas con Wi-Fi gratis, televisión de pantalla plana, base para iPod, minibar y sala de estar. Las habitaciones de categoría superior disponen de sofá cama, cafetera y tetera; algunas tienen terraza. Las suites cuentan con cocina y balcón amueblado.\n" +
                        "El hotel dispone de una sala de desayunos informal con una claraboya, un restaurante sofisticado con ventanas de suelo a techo, un bar de deportes con una mesa de billar y sushi, un gimnasio y un spa.",
                        "4.6918426","-74.0340631",R.drawable.h_hotelnh));

                add(new Hotel("","","","","","",R.drawable.s_monserrate));



            }};

            datos.guardarHoteles(hotel);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void ingresarRestaurantes() {

        try {
            restaurante=new ArrayList<Restaurante>(){{
                add(new Restaurante("Juana La Loca","Buenos cocteles, agradable grupos","Calle 90 # 11-13, Bogotá"," Del primer menú de Juana La Loca quedan pocos platillos. Los chicharrones de cochinillo con lima y jalapeño son de los pocos que sobreviven a ese difícil comienzo, hace dos años. De ese momento quedarán otros cinco platos, como clásicos de siempre –dice Rafael Londoño, al frente de la marca–. Pero, pasados unos ocho meses de funcionamiento empezamos el proceso de reformar la carta”.\n" +
                        "Londoño recuerda que se estrenó en el mundo de los restaurantes con Juana la Loca, cuando se asoció con el grupo Tragaluz de Barcelona. Pero no fue tan sencillo traer las cosas que eran exitosas en la ciudad catalana a Bogotá.",
                        "4.672065","-74.05126",R.drawable.r_juanalaloca));


                add(new Restaurante("La fragata Giratoria","El Restaurante La Fragata Giratorio es un sitio en donde se puede degustar comida de excelencia a base de productos marinos.",
                        "Calle 100 # 8A-55 Piso 12. W.T.C","El Restaurante La Fragata Giratorio es un sitio en donde se puede degustar comida de excelencia a base de productos marinos. Su calidad está garantizada con una tradición de más de cuarenta años en otras ciudades de Colombia. Desde el espacioso y sofisticado local, se alcanza una vista única del norte capitalino y sus cerros, lugar ideal para compartir con la familia, amigos o pasar el rato en solitario. En su carta se destaca el famoso plato Langostino Fragata, acompañado de arroz con coco, plátano gratinado y una salsa exclusiva de la casa. Otras de sus creaciones son el seviche costeño, el seviche peruano, los rollos de anguila y el más completo de todos. langosta 3 sabores. La opción de entrante más solicitada es la sopa caldereta de cangrejos y, para el postre, se ofrecen opciones ligeras, como el postre de natas y la torta de café. La oferta del menú infantil da la oportunidad de reunirse para festejos de todo tipo. Además del comedor, cuenta con un café y una barra de sushi. En el restaurante se celebran festivales de comida nacional e internacional a los que asisten cocineros y chefs extranjeros, y en los que se presentan recetas que enriquecen el menú de La Fragata Giratorio todos los años.",
                        "4.6810056","-74.04333",R.drawable.r_fragata));

                add(new Restaurante("Criterion","Criterion es el primer restaurante de alta cocina de los hermanos Rausch y su taller creativo.",
                        "Calle 69A # 5-75","Criterion es el primer restaurante de alta cocina de los hermanos Rausch y su taller creativo. \n" +
                        " Ofrecen una cocina de autor moderna y sofisticada, utilizando en la mayoría de sus preparaciones productos locales y reinventando recetas tradicionales de la gastronomía colombiana que podemos encontrar en el menú, como la posta negra cartagenera, el merengón de guanábana o chimichurri chontaduro en magret de pato. \n" +
                        " Además de los platos de la carta, Criterión ofrece la oportunidad de disfrutar el menú degustación, un concepto que precisamente llevaron los hermanos Rausch a Colombia y trata de la experiencia completa del restaurante a través de diferentes y variados platos, inspirados en satisfacer su apetito. \n" +
                        " Su lema “El producto final nunca puede ser mejor que su materia prima”, deja claro el trabajo y la dedicación que los hermanos Raush ponen en cada una de sus creaciones. ",
                        "4.6517161","-74.058187",R.drawable.r_criterion));

                add(new Restaurante("Tramonti","Entre montañas y bosques naturales desde donde se observa una de las mejores vista de Bogotá, se encuentra este chalet que tiene 25 años de tradición",
                        "Carrera 1ra N° 93-50","Entre montañas y bosques naturales desde donde se observa una de las mejores vista de Bogotá, se encuentra este chalet que tiene 25 años de tradición y que ofrece cocina mediterránea con carnes y pastas.\n" +
                        " Tramonti es un lugar para no olvidar, único, romántico, ideal no sólo para almorzar o cenar, sino con el ambiente para realizar todo tipo de celebraciones, que sin duda serán memorables. Algunas de las entradas frías, son tonno sardegna, selezione di antipasti, carpaccio di manzo, carpaccio di salmone e tonno, selezione di tapas di spagna, trio di ceviche. como entradas calientes hay calamari fritti e tapenade, funghi all´aglio, crostino di gamberetti e feta, cuore di palma con gamberetti e curry, entre otras. Las oferta de ensaladas contiene insalata vito d´asio, insalata greca, insalata dell´ angello, insalata montana, entre otras.\n" +
                        " Si la chimenea que tiene el restaurante no basta para contrarrestar el frío de los cerros orientales, la propuesta de sopas incluye zuppa di cipolle alla francese, zuppa di cipolle e sfoglia di funghi, zuppa di pomodoro alla griglia, minestrone classico.\n" +
                        " La elegancia del lugar no es obstáculo para encontrar opciones más informales y típicas de otras regiones como la tortilla española, el chori pan, el queso manchego y las empanadas argentinas, entre otros, como opciones para picar.\n" +
                        " Para los amantes de la carne, podrán disfrutar de excelentes cortes como punta de anca (400 gms), filet mignon, baby beef (400 gms), lombata tramonti con roquefort, costola di maiale al barbecue, coniglio al timo, ossobuco di abba, pollo ai funghi.\n" +
                        " Si la preferencia son pastas, estas son las opciones: pappardelle ai funghi, spaghetti neri, spaghetti al pomodoro, canelloni tramonti, gnocchi della famiglia, risotto del bosco, risotto mediterraneo, risotto nero di mare, los cocteles tramonti milenio (cognanc, vodka, amaretto y jugo de naranja) y tramonto (vodka, jugo de naranja y granadina) son sólo algunas de la variedad que se encuentra en el restaurante, además de otros más tradicionales como margarita, piña colada, daiquiri de fresa, mojito, dry martini, canelazo de aguardiente, sangría, entre otros.",
                        "4.6677515","-74.0530483",R.drawable.r_tramonti));

                add(new Restaurante("Tratoria La Divina Comedia","Es una buena invitación para sentirse como en casa, ","Calle 71 # 5-73",
                        "Ubicado en el norte de la ciudad, La Divina Comedia es una buena invitación para sentirse como en casa, pues su chef Sergio Martin proviene de familia italiana y busca evocar y difundir de manera moderna, las enseñanzas que le dejo su nonna a su padre.\n" +
                                " Además de tener la referencia del libro de recetas de familia, el chef tiene gran experiencia en el arte de cocinar, el cual también difunde a través de cursos de pasta fresca, de programas de televisión y de su blog.\n" +
                                " Con una presentación de los platos sobria y elaborada de los platos, el restaurante divide su carta entre pastas cortas, pastas frescas y pastas rellenas. Además de remontarse al nombre del sitio, ofreciendo un aparte para los platos Del Paraíso (ristottos), Del Purgatorio (tortellis y tortellonis) y Del Inferno (varias opciones). Su especialidad es la pasta rellena, como el Canelloni Dante. De otros platos, también se recomienda el risotto funghi, el spaghetti Tripomodoro y el Penne Primavera. Quienes desean otras opciones más ligeras, hay variedad de ensaladas y sopas. \n" +
                                " En un ambiente cálido y sencillo con mesas de madera, sillas rojas y manteles blancos, se puede disfrutar también de diferentes risottos, pescados y carnes.\n" +
                                " Un buen cierre por el sitio se puede hacer con un tiramisú y uno de los vinos seleccionados que tienen.",
                        "4.653567","-74.0571337",R.drawable.r_tratoria));
              }};
            datos.guardarRestaurantes(restaurante);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
