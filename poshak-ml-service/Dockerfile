FROM continuumio/miniconda:latest

WORKDIR /poshak-ml-service

COPY poshak-ml-service /poshak-ml-service

RUN ls

RUN conda env create -f environment.yml

RUN echo "source activate speMLLL" >> ~/.bashrc
ENV PATH /opt/conda/envs/speMLLL/bin:$PATH

EXPOSE 5000
CMD ["python", "main.py"]
