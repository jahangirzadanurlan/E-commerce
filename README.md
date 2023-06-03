# e-commerce
E-commerce
Building 187C, 115 Heydar Aliyev Ave, Baku 1029  055 032 77 78
ecommerce@gmail.com  www.ecommerce.com


Div students
Basic project for exam


SCenario

E-commerce

Mövcud problemlər

Ənənəvi ticarət insanlarımız üçün bir çox çətinliklər və vaxt itkisi yaradır. İnsanlar məhsul almaq üçün mağazalara getməli, uzun növbələrdə gözləməli və vaxtlarını itirməli olurlar. Bu vəziyyət həm onların vaxtlarını itməsinə səbəb olur, həm də iş prosesini çətinləşdirir.

Problemin həllinin təsviri

E-ticarət saytı yaratmaqla istifadəçilərə məhsulları kəşf etmək, onları səbətə əlavə etmək və asanlıqla almaq imkanı təqdim edəcəyik. Beləliklə, insanlar alış-verişlərini daha praktik, sürətli və marağla edə biləcəklər.

Yaradılacağ proyektdə bu 5 əsas problem öz həllini tapmalıdır.
İstifadəçi qeydiyyatı imkanı (Sadəcə simulyasiya edin. Baza da static olarağ saxlayın və elə istifadə edin.)
Məhsul əlavə etmək
Səbət əməliyyatlarını (var olan məhsulun səbətə əlavə olunması, çıxarılması, sayının artırılması)
Məhsulların, kategoriya və brendlərə görə müəyyən strukturda saxlanılması və bunlara görə axtarışı edə bilmək imkanı
Ödənişi keçirmək



Model:

Category – id, name, desc
Brand – id, name, desc
Product – İd, name, desc, amount, remainCount, productDetails
User – id, name, surname, birthdate, email, address
Cart – id, product, count, total amount

Qeyd: Bu cədvəllər arasında ola biləcək əlaqələr, field üzərində göstərilməyib. Bunları özünüz qurmalısınız.


Endpoints:

/categories
    GET – all category
     POST – save category
     /{id}
         GET – find by id
         PUT – update category
     
    /brands
        GET – all brands
          POST – save brand
          /{id}
              GET – find by id
              PUT – update brand
      
          /products
            GET – all products or search(RequestParam)
              POST – save product
          /{id}
              GET – find by id
              PUT – update product
 /cart
    GET – all product in cart --findAll()
     POST – add product to cart--save()
     DELETE – remove product from cart --delete()
    /checkout – (kart məlumatlarını daxil edəcək və ödəniş olunmasını simulyasiya edəcəyik.)
        POST – buy product in cart --update()















