package amsi.dei.estg.ipleiria.layout.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;



import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.BebidasFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.ComplementosFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.ContactosFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.FavoritoFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.HamburguerFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.HistoricoFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.LogoutFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.PedidoFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.PerfilFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.ProdutosFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.PromocoesFragment;
import amsi.dei.estg.ipleiria.layout.vista.fragmentos.SobremesasFragment;


public class MenuPrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_main);

        //incorporar a toolbar na vista
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawer=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle= new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toogle.syncState();
        drawer.addDrawerListener(toogle);
        //ativar o serviço de escuta
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager=getSupportFragmentManager();

        loadFragmentoInicial();

    }

    private void loadFragmentoInicial() {
        navigationView.setCheckedItem(R.id.nav_produtos);
        Fragment fragmento = new ProdutosFragment();
        fragmentManager.beginTransaction().replace(R.id.contentFragment, fragmento).commit();
        setTitle("Produtos");
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragmento=null;
        int id=menuItem.getItemId();
        switch(id){

            case R.id.nav_produtos:
                fragmento=new ProdutosFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_promocao:
                fragmento=new PromocoesFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_favorito:
                fragmento=new FavoritoFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_pedido:
                fragmento=new PedidoFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_historicoPedidos:
                fragmento=new HistoricoFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_perfil:
                fragmento=new PerfilFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_contactos:
                fragmento=new ContactosFragment();
                setTitle(menuItem.getTitle());
                break;
            case R.id.nav_logout:
                fragmento=new LogoutFragment();
                setTitle(menuItem.getTitle());
                break;

            default:
        }

        fragmentManager.beginTransaction().replace(R.id.contentFragment, fragmento).commit();
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


}
