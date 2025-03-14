package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String address;
  private String city;
  private int zip;

  @OneToMany
  @JoinColumn(name = "publisher_id")
  private Set<Book> booksPublished = new HashSet<>();

  public Publisher()
  {
  }

  public Publisher(String name, String address, String city, int zip)
  {
    this.name = name;
    this.address = address;
    this.city = city;
    this.zip = zip;
  }

  public Set<Book> getBooksPublished()
  {
    return booksPublished;
  }

  public void setBooksPublished(Set<Book> booksPublished)
  {
    this.booksPublished = booksPublished;
  }

  @Override public String toString()
  {
    return "Publisher{" + "id=" + id + ", name='" + name + '\'' + ", address='"
        + address + '\'' + ", city='" + city + '\'' + ", zip=" + zip + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Publisher publisher = (Publisher) o;

    return Objects.equals(id, publisher.id);
  }

  @Override public int hashCode()
  {
    return id != null ? id.hashCode() : 0;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public int getZip()
  {
    return zip;
  }

  public void setZip(int zip)
  {
    this.zip = zip;
  }
}
