package com.ventas.demo.dao.api.mpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import org.jboss.logging.Logger;

import com.ventas.demo.dao.api.ProductoDaoAPI;
import com.ventas.demo.model.Producto;

/**
 * Clase que implementa los metodos de la clase productoDaoAPI producto.
 * @author Pablo Hincapie Creado el 09/05/2020 a 05:10:14 am <br>
 *
 */
@Repository
public class ProductoDaoAPIImpl implements ProductoDaoAPI {

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceContext
	EntityManager emUpdate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ventas.demo.dao.api.ProductoDaoAPI#UpdateQuantity(com.ventas.demo.
	 * model.Producto)
	 */
	public void UpdateQuantity(Producto producto) {
		try {

			String sql = "update Producto p set p.cantidad= :cantidad where  p.referencia= :id ";
			Query query = emUpdate.createQuery(sql);
			query.setParameter("cantidad", producto.getCantidad());
			query.setParameter("id", producto.getReferencia());
			query.executeUpdate();

		} catch (NoResultException e) {
			Logger.getLogger("No hay datos");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ventas.demo.dao.api.ProductoDaoAPI#UpdateQuantity(com.ventas.demo.
	 * model.Producto)
	 */
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("null")
	public Producto findProductoByReferencia(String referencia) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/BaseDatosVentas";
		String user = "postgres";
		String password = "postgres";

		Producto productoResult = new Producto();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "select cantidad,id_producto, referencia from producto  where referencia = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, referencia);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				productoResult.setCantidad(resultSet.getInt("cantidad"));
				productoResult.setId_producto(resultSet.getLong("id_producto"));
				productoResult.setReferencia(resultSet.getString("referencia"));
			}
		} finally {
			resultSet.close();
		}

		return productoResult;

	}

}
